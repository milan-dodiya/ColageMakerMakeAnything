package com.collagemaker_makeanything.StoreFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.collagemaker_makeanything.Adapter.Filter_Adapter
import com.collagemaker_makeanything.Api.OkHttpHelperFilter
import com.collagemaker_makeanything.Api.ftData
import com.collagemaker_makeanything.Api.ftGroup
import com.collagemaker_makeanything.databinding.FragmentFilterBinding
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties


class FilterFragment : Fragment() {
    private lateinit var binding: FragmentFilterBinding
//
    lateinit var adapter: Filter_Adapter

    private val groupsList = mutableListOf<ftGroup>()
    private val filteredGroupsList = mutableListOf<ftGroup>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ::adapter.isInitialized
        initView()
    }

    private fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = Filter_Adapter(filteredGroupsList)
        binding.recyclerView.adapter = adapter

        val url =
            "https://s3.ap-south-1.amazonaws.com/photoeditorbeautycamera.app/collagemaker/filternew.json"

        requireActivity().runOnUiThread {
            binding.progressBar.visibility = View.VISIBLE
        }

        OkHttpHelperFilter.fetchFilter(url) { filterApi ->
            requireActivity().runOnUiThread {
                binding.progressBar.visibility = View.GONE

                if (filterApi != null) {
                    Log.e("StoreFragment", "Fetched data: ${filterApi.data}")

                    filterApi.data?.let {
                        populateGroupsList(it)
                        requireActivity().runOnUiThread {
                            adapter.updateData(filteredGroupsList)
                        }
                    } ?: Log.e("StoreFragment", "Data is null")
                } else {
                    Log.e("StoreFragment", "Failed to fetch data")
                }
            }
        }

        // Initialize the SearchView
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Do nothing here
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterGroupsList(newText ?: "")
                return true
            }
        })
    }

    private fun filterGroupsList(query: String?) {
        filteredGroupsList.clear()
        if (query.isNullOrEmpty()) {
            filteredGroupsList.addAll(groupsList)
        } else {
            val filteredList = groupsList.filter { it.textCategory!!.contains(query, true) }
            filteredGroupsList.addAll(filteredList)
        }
        adapter.notifyDataSetChanged()
    }

    private fun populateGroupsList(data: ftData) {
        val items = mutableListOf<ftGroup>()

        // Use Kotlin reflection to iterate over the properties of the Dataes class
        data::class.memberProperties.forEach { property ->
            val prop = property as? KProperty1<ftData, *>
            val value = prop?.get(data)

            // Check if the value is an instance of a class containing a Groupess
            if (value != null) {
                // Use reflection to find the Groupess property within the nested class
                val groupProperty = value::class.memberProperties
                    .firstOrNull { it.returnType.classifier == ftGroup::class }
                        as? KProperty1<Any, ftGroup>

                val nestedGroup = groupProperty?.get(value)

                if (nestedGroup != null) {
                    val categoryName = property.name.replace("_", " ").capitalizeWords()

                    nestedGroup.let {
                        if (it.subImageUrl != null || it.mainImageUrl != null) {
                            items.add(
                                ftGroup(
                                    subImageUrl = it.subImageUrl,
                                    mainImageUrl = it.mainImageUrl,
                                    textCategory = categoryName,
                                    premium = it.premium
                                )
                            )
                        }
                    }
                }
            }
        }

        groupsList.clear()
        groupsList.addAll(items)
        filteredGroupsList.clear()
        filteredGroupsList.addAll(groupsList)
        adapter.notifyDataSetChanged()
    }

        // Extension function to capitalize words
        private fun String.capitalizeWords(): String =
            split(" ").joinToString(" ") { it.capitalize() }


}
