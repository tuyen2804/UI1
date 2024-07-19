package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.LibraryInterface
import com.example.myapplication.R
import com.example.myapplication.DataItem.ItemAll

class LibraryAdapter(private val items: List<ItemAll>, private val onClickFile: LibraryInterface) : RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {

    data class Item(val imageResId: Int, val text: String)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewItem)
        val textView: TextView = view.findViewById(R.id.textViewItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_all, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textView.text = item.text
        holder.itemView.setOnClickListener {
            onClickFile.onClickFile(position, holder.textView.text.toString())
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
