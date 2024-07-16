package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LibraryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        val items = mutableListOf<LibraryAdapter.Item>()
        for (i in 1..10) {
            items.add(LibraryAdapter.Item(R.drawable.a1, "Image $i", "Select"))
        }

        adapter = LibraryAdapter(items)
        recyclerView.adapter = adapter

        return view
    }
}
