package com.example.bookmyshow

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatSelectionActivity : AppCompatActivity() {

    private lateinit var selectedSeats: MutableList<Int>
    private lateinit var btnPayAndConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val movieName = intent.getStringExtra("MOVIE_NAME") ?: "Unknown"
        val theaterName = intent.getStringExtra("THEATER_NAME") ?: "Unknown"
        val dateTime = intent.getStringExtra("SHOW_TIME") ?: "Unknown"

        findViewById<TextView>(R.id.tvMovieName).text = movieName
        findViewById<TextView>(R.id.tvTheaterName).text = theaterName
        findViewById<TextView>(R.id.tvDateTime).text = dateTime

        selectedSeats = mutableListOf()
        btnPayAndConfirm = findViewById(R.id.btnPayAndConfirm)

        setupSeatGrid(R.id.platinumSeats, 1, 25, 250)
        setupSeatGrid(R.id.goldSeats, 26, 75, 170)
        setupSeatGrid(R.id.silverSeats, 76, 100, 140)

        btnPayAndConfirm.setOnClickListener {
            val intent = Intent(this, BookingConfirmationActivity::class.java)
            intent.putExtra("MOVIE_NAME", movieName)
            intent.putExtra("THEATER_NAME", theaterName)
            intent.putExtra("SHOW_TIME", dateTime)
            intent.putIntegerArrayListExtra("selectedSeats", ArrayList(selectedSeats))
            startActivity(intent)
        }
    }

    private fun setupSeatGrid(gridId: Int, start: Int, end: Int, price: Int) {
        val gridLayout = findViewById<GridLayout>(gridId)
        for (seat in start..end) {
            val seatButton = Button(this)
            seatButton.text = seat.toString()
            seatButton.setPadding(8, 8, 8, 8)
            seatButton.setBackgroundResource(android.R.drawable.btn_default)

            seatButton.setOnClickListener {
                if (selectedSeats.contains(seat)) {
                    selectedSeats.remove(seat)
                    seatButton.setBackgroundResource(android.R.drawable.btn_default)
                } else if (selectedSeats.size < 5) {
                    selectedSeats.add(seat)
                    seatButton.setBackgroundColor(Color.GREEN)
                } else {
                    Toast.makeText(this, "You can select up to 5 seats only", Toast.LENGTH_SHORT).show()
                }

                btnPayAndConfirm.visibility = if (selectedSeats.isNotEmpty()) View.VISIBLE else View.GONE
            }
            gridLayout.addView(seatButton)
        }
    }
}
