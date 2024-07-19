package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ImageAdapter(
    private val items: List<Item>
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    data class Item(val imageResId: Int, val text: String)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewItem: ImageView = itemView.findViewById(R.id.imageViewItem)
        val textViewItem: TextView = itemView.findViewById(R.id.textViewItem)

        fun bind(item: Item) {
            imageViewItem.setImageResource(item.imageResId)
            textViewItem.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
