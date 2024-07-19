package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.ImageAdapter

class ImageFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)

        // Sample data
        val items = listOf(
            ImageAdapter.Item(R.drawable.a1, "Item 1"),
            ImageAdapter.Item(R.drawable.a1, "Item 2"),
            ImageAdapter.Item(R.drawable.a1, "Item 3"),
            ImageAdapter.Item(R.drawable.a1, "Item 4"),
            ImageAdapter.Item(R.drawable.a1, "Item 5"),
            ImageAdapter.Item(R.drawable.a1, "Item 6"),
            ImageAdapter.Item(R.drawable.a1, "Item 7"),
            ImageAdapter.Item(R.drawable.a1, "Item 8"),
            ImageAdapter.Item(R.drawable.a1, "Item 9")
        )

        // Initialize the adapter with items
        adapter = ImageAdapter(items)

        // Set up GridLayoutManager with 3 columns
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }
}
