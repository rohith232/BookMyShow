package com.example.bookmyshow

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LanguageSelectionActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_selection)

        // Initialize buttons for different languages
        val btnTelugu = findViewById<Button>(R.id.btnTelugu)
        val btnEnglish = findViewById<Button>(R.id.btnEnglish)
        val btnHindi = findViewById<Button>(R.id.btnHindi)
        val btnTamil = findViewById<Button>(R.id.btnTamil)
        val btnMalayalam = findViewById<Button>(R.id.btnMalayalam)

        // Example for English language button
        findViewById<Button>(R.id.btnEnglish).setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra("selected_language", "English")
            startActivity(intent)
        }

// Repeat similar setup for other language buttons
        findViewById<Button>(R.id.btnHindi).setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra("selected_language", "Hindi")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnTamil).setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra("selected_language", "Tamil")
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnTelugu).setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra("selected_language", "Telugu")
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnMalayalam).setOnClickListener {
            val intent = Intent(this, MovieListActivity::class.java)
            intent.putExtra("selected_language", "Malayalam")
            startActivity(intent)
        }

    }

    // Function to navigate to the movie list based on the selected language
    private fun navigateToMovieList(language: String) {
        val intent = Intent(this, MovieListActivity::class.java)
        intent.putExtra("language", language)
        startActivity(intent)
//    }
    }
}
