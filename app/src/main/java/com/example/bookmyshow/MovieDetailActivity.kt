package com.example.bookmyshow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieTitleDetail: TextView
    private lateinit var movieImageDetail: ImageView
    private lateinit var movieDescriptionDetail: TextView
    private lateinit var bookTicketsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        // Initialize views
        movieTitleDetail = findViewById(R.id.movieTitle)
        movieImageDetail = findViewById(R.id.movieImage)
        movieDescriptionDetail = findViewById(R.id.movieDescription)
        bookTicketsButton = findViewById(R.id.bookTicketsButton)

        // Get movie data from the Intent
        val movieTitle = intent.getStringExtra("movie_title")
        val movieDescription = intent.getStringExtra("movie_description")
        val movieImageResource = intent.getIntExtra("movie_image_resource", -1)

        // Set the data to the views
        movieTitleDetail.text = movieTitle
        movieDescriptionDetail.text = movieDescription

        // Set the local movie image using setImageResource
        if (movieImageResource != -1) {
            movieImageDetail.setImageResource(movieImageResource)
        }


        // Set onClickListener for the Book Tickets Button
        bookTicketsButton.setOnClickListener {
            // You can handle the booking logic here, for now, just a placeholder action
            // For example, you could start another activity or show a toast
            val intent = Intent(this, SelectTheaterActivity::class.java)
            intent.putExtra("MOVIE_NAME", movieTitle) // Pass the movie name
           // intent.putExtra("movie_image_resource", movieImageResource)
            startActivity(intent)
        }
    }
}


