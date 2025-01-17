package com.collagemaker_makeanything.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.collagemaker_makeanything.R

import java.io.File

class SavepathAdapter(
    private val directories: List<File>,
    private val onDirectoryClick: (File) -> Unit
) : RecyclerView.Adapter<SavepathAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)

        fun bind(directory: File) {
            textView.text = directory.name
            itemView.setOnClickListener { onDirectoryClick(directory) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_directory, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(directories[position])
    }

    override fun getItemCount(): Int {
        return directories.size
    }
}
