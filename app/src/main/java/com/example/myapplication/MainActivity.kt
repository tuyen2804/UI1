package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RvAdapter
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, PhotoLibraryActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val items = listOf(
            RvAdapter.Item(R.drawable.ic_launcher_foreground, "Item 1", "Button 1"),
            RvAdapter.Item(R.drawable.ic_launcher_foreground, "Item 2", "Button 2"),
            RvAdapter.Item(R.drawable.ic_launcher_foreground, "Item 3", "Button 3"),
            RvAdapter.Item(R.drawable.ic_launcher_foreground, "Item 4", "Button 4")
        )

        adapter = RvAdapter(items)
        recyclerView.adapter = adapter
    }
}
