package com.collagemaker_makeanything.StoreFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.collagemaker_makeanything.databinding.FragmentTextBinding


class TextFragment : Fragment(){

    private lateinit var binding: FragmentTextBinding
   // lateinit var adapter: com.collagemaker_makeanything.Adapter.CollageTemplateAdapter
//    lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

    }
}