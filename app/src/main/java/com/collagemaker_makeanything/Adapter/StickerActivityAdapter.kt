package com.collagemaker_makeanything.Adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.collagemaker_makeanything.Api.stGroup
import com.collagemaker_makeanything.Class.OnStickerClickListener
import com.collagemaker_makeanything.Class.StickerClickListener
import com.collagemaker_makeanything.R


class  StickerActivityAdapter(var activity: Activity, var data: MutableList<stGroup>, private val listener: OnStickerClickListener,
                              var listeners : StickerClickListener
) : RecyclerView.Adapter<StickerActivityAdapter.StickerActivityAdapter>() {

    private val baseUrl = "https://s3.ap-south-1.amazonaws.com/photoeditorbeautycamera.app/collagemaker/sticker/"
    private var filteredData: MutableList<stGroup> = data // Store the filtered data

    companion object{
        var imageUrlList = listOf<String>()
    }

    fun updateData(newData: MutableList<stGroup>)
    {
        data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerActivityAdapter
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sticker_activity_item, parent, false)
        Log.e("StoreFragment", "onCreateViewHolder: " + itemView)
        return StickerActivityAdapter(itemView)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StickerActivityAdapter, position: Int)
    {
        val stickerUrl = data[position]

        val item = data.getOrNull(position) ?: return

        imageUrlList = (item.subImageUrl as List<String>?)!!
        if (imageUrlList.isNullOrEmpty())
        {
            Log.e("StickerAdapter", "No image URLs available for position $position")
            holder.imageView.setImageResource(R.drawable.cross) // Placeholder image
            return
        }

        val imageUrl = stickerUrl.subImageUrl!!.get(0)

        if (imageUrl != null)
        {
            // Load image using Glide
            Glide.with(holder.itemView.context)
                .load(baseUrl + imageUrl)
                .fitCenter()
                .centerCrop()
                .into(holder.imageView)


            holder.imageView.setOnClickListener {
                // Show the category as a toast
                Toast.makeText(holder.itemView.context, stickerUrl.textCategory, Toast.LENGTH_SHORT).show()

                // Get the RecyclerView from your activity or fragment layout
                val recyclerView = (holder.itemView.context as Activity).findViewById<RecyclerView>(R.id.rcvStikers)

                // Set up the RecyclerView if it's not set already
                if (recyclerView.adapter == null)
                {
                    recyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 4) // 4 columns grid
                    recyclerView.adapter = Sticker_Group_Images_Adapter(imageUrlList,listeners) // Pass your image list
                }

                // Notify the activity with the image URLs
                stickerUrl.subImageUrl?.let { urls ->
                    listener.onStickerClicked(urls) // Send the image URLs to the activity
                }

                // Make the RecyclerView visible
                recyclerView.visibility = View.VISIBLE

                // Optionally, you can also hide or collapse it if clicked again
            }
        }
        else
        {
            // Handle case where imageUrl is null
            Log.e("ImageLoading", "No image URL available for position $position")
        }
    }

    override fun getItemCount(): Int
    {
        return data.size
    }

    class StickerActivityAdapter(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView: ImageView = itemView.findViewById(R.id.imgSticker)
    }
}