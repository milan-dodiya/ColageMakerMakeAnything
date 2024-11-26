package com.collagemaker_makeanything.Adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.collagemaker_makeanything.Api.ftGroup
import com.collagemaker_makeanything.R
import com.collagemaker_makeanything.StoreFragment.FilterBottomSheetDialogFragment


class Filter_Adapter(private var data: MutableList<ftGroup>) : RecyclerView.Adapter<Filter_Adapter.FilterViewHolder>() {

    private val baseUrl = "https://s3.ap-south-1.amazonaws.com/photoeditorbeautycamera.app/collagemaker/filter/"

    fun updateData(newData: MutableList<ftGroup>) {
        data = newData
        Log.d("Adapter", "Updated data size: ${data.size}")
        data.forEachIndexed { index, item ->
            Log.d("Adapter", "Item $index: ${item.javaClass.simpleName}, value: $item")
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sticker, parent, false)
        return FilterViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FilterViewHolder, position: Int)
    {
        val FilterItem = data.getOrNull(position)

        if (FilterItem is ftGroup)
        {
            val imageUrl = FilterItem.mainImageUrl?.firstOrNull()
            if (imageUrl != null)
            {
                Glide.with(holder.itemView.context)
                    .load(baseUrl + imageUrl)
                    .fitCenter()
                    .centerCrop()
                    .into(holder.imageView)
            }
            else
            {
                holder.imageView.setImageResource(R.drawable.cross) // Placeholder image
            }

            holder.txtName.text = FilterItem.textCategory
            holder.txtNumber.text = "${FilterItem.subImageUrl?.size ?: 0} Filters"

            holder.itemView.setOnClickListener {
                val activity = it.context as? FragmentActivity
                activity?.let {
                    val bottomSheetDialogFragment = FilterBottomSheetDialogFragment.newInstance(FilterItem.subImageUrl, R.color.black,
                        FilterItem.textCategory.toString()
                    )
                    bottomSheetDialogFragment.show(it.supportFragmentManager, bottomSheetDialogFragment.tag)
                }
            }
        }
        else
        {
            Log.e("Adapter", "Unexpected data type at position $position: ${FilterItem?.javaClass?.simpleName}")
        }
    }

    override fun getItemCount(): Int
    {
        return data.size
    }

    class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView: ImageView = itemView.findViewById(R.id.imgSticker)
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtNumber: TextView = itemView.findViewById(R.id.txtNumber)
    }
}