package com.example.bookmyshow


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.bookmyshow.BookingConfirmationActivity

class ConfirmationActivity1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_confirmation)



        val movieName = intent.getStringExtra("movieName")
        val theaterName = intent.getStringExtra("theaterName")
        val dateTime = intent.getStringExtra("dateTime")
        val selectedSeats = intent.getIntegerArrayListExtra("selectedSeats") ?: arrayListOf()

        //retrieving the image
        val movieImageUrl = intent.getStringExtra("MOVIE_IMAGE_URL") // Retrieve movie image URL


        // Load movie image using Glide
        val moviePoster = findViewById<ImageView>(R.id.ivMoviePoster)
        Glide.with(this)
            .load(movieImageUrl) // Use the retrieved movie image URL
            .placeholder(R.drawable.sample_poster) // Fallback image
            .error(R.drawable.error_placeholder) // Error image
            .into(moviePoster)


        val bookingDetails = """
            Movie: $movieName
            Theater: $theaterName
            Date & Time: $dateTime
            Seats: ${selectedSeats.joinToString(", ")}
        """.trimIndent()

        findViewById<TextView>(R.id.tvBookingDetails).text = bookingDetails
    }
}
