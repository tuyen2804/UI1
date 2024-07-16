package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhotoLibraryActivity : AppCompatActivity() {

    private lateinit var buttonSelect: Button
    private lateinit var textViewSelectedCount: TextView
    private lateinit var textViewLibraryTitle: TextView
    private lateinit var buttonAll: Button
    private lateinit var buttonBrowser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_library)

        buttonSelect = findViewById(R.id.buttonSelect)
        textViewSelectedCount = findViewById(R.id.textViewSelectedCount)
        textViewLibraryTitle = findViewById(R.id.textViewLibraryTitle)
        buttonAll = findViewById(R.id.buttonAll)
        buttonBrowser = findViewById(R.id.buttonBrowser)


        buttonAll.setOnClickListener {
            textViewLibraryTitle.text = "Library > All"
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AllFragment())
                .commit()
        }

        buttonBrowser.setOnClickListener {
            textViewLibraryTitle.text = "Library > Browser"
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, BrowserFragment())
                .commit()
        }
    }
}
