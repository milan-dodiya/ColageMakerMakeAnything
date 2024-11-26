package com.collagemaker_makeanything.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.collagemaker_makeanything.Class.StickerClickListener
import com.collagemaker_makeanything.R

class Sticker_Group_Images_Adapter(
    var data: List<String>,
    private val listener: StickerClickListener
) : RecyclerView.Adapter<Sticker_Group_Images_Adapter.Sticker_Activity_Adapter>() {

    private val baseUrl = "https://s3.ap-south-1.amazonaws.com/photoeditorbeautycamera.app/collagemaker/sticker/"

    fun updateData(newData: List<String>) {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Sticker_Activity_Adapter {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sticker_activity_item, parent, false)
        return Sticker_Activity_Adapter(itemView)
    }

    override fun onBindViewHolder(holder: Sticker_Activity_Adapter, position: Int) {
        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(baseUrl + data[position])
            .fitCenter()
            .centerCrop()
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            Log.e("Sticker_Group_Images_Adapter", "Image clicked: ${data[position]}")
            // Notify the listener that an image has been clicked
            listener.onStickerSelected(baseUrl + data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class Sticker_Activity_Adapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgSticker)
    }
}