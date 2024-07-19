package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.Adapter.LibraryAdapter
import com.example.myapplication.DataItem.ItemAll
import com.example.myapplication.databinding.FragmentAllBinding

class AllFragment : Fragment(), LibraryInterface {

    private var _binding: FragmentAllBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: LibraryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        val items = mutableListOf<ItemAll>()
        for (i in 1..10) {
            items.add(ItemAll(R.drawable.a1, "size$i"))
        }

        adapter = LibraryAdapter(items, this)
        binding.recyclerView.adapter = adapter
    }

    override fun onClickFile(position: Int, text: String) {
        if (text == "size1") {

            binding.recyclerView.visibility = View.GONE
            binding.fragmentContainerView.visibility = View.VISIBLE

            childFragmentManager.commit {
                replace(R.id.fragmentContainerView, ImageFragment())
                addToBackStack(null)
            }
        } else {
            Toast.makeText(requireContext(), "Item clicked at position $position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
