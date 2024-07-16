package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LibraryAdapter(private val items: List<Item>) : RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {

    data class Item(val imageResId: Int, val text: String, val buttonText: String)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewItem)
        val textView: TextView = view.findViewById(R.id.textViewItem)
        val button: RadioButton = view.findViewById(R.id.buttonItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textView.text = item.text
        holder.button.text = item.buttonText
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
