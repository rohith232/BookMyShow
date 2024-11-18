package com.example.bookmyshow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookingConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val movieName = intent.getStringExtra("MOVIE_NAME") ?: "Unknown Movie"
        val theaterName = intent.getStringExtra("THEATER_NAME") ?: "Unknown Theater"
        val dateTime = intent.getStringExtra("SHOW_TIME") ?: "Unknown Time"
        val selectedSeats = intent.getIntegerArrayListExtra("selectedSeats") ?: arrayListOf()
        val movieImageUrl = intent.getStringExtra("MOVIE_IMAGE_URL") // Retrieve movie image URL


        val totalPrice = calculateTotalPrice(selectedSeats)

        // Set booking details
        val bookingDetails = """
            🎥 Movie: $movieName
            🏢 Theater: $theaterName
            🕒 Date & Time: $dateTime
            🎟️ Seats: ${selectedSeats.joinToString(", ")}
            💰 Total Price: ₹$totalPrice
        """.trimIndent()

        val bookingDetailsTextView = findViewById<TextView>(R.id.tvBookingDetails)
        bookingDetailsTextView.text = bookingDetails
        // Load movie image using Glide
        val moviePoster = findViewById<ImageView>(R.id.ivMoviePoster)
        Glide.with(this)
            .load(movieImageUrl) // Use the retrieved movie image URL
            .placeholder(R.drawable.sample_poster) // Fallback image
            .error(R.drawable.error_placeholder) // Error image
            .into(moviePoster)


        val fabHome = findViewById<FloatingActionButton>(R.id.fabHome)
        // Set an onClick listener for the FAB
        fabHome.setOnClickListener {
            // Start HomeActivity when the FAB is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // Confirm Button Action
        val confirmButton = findViewById<Button>(R.id.btnConfirm)
        confirmButton.setOnClickListener {
            Toast.makeText(this, "Booking Confirmed!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateTotalPrice(seats: List<Int>): Int {
        var total = 0
        for (seat in seats) {
            total += when {
                seat in 1..25 -> 250
                seat in 26..75 -> 170
                seat in 76..100 -> 140
                else -> 0 // Invalid seat numbers will not add to the total
            }
        }
        return total
    }
}
