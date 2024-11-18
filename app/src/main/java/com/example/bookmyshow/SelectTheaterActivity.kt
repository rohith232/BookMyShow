package com.example.bookmyshow

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmyshow.adapter.TheaterAdapter
import java.text.SimpleDateFormat
import java.util.Locale

class SelectTheaterActivity : AppCompatActivity() {


    private lateinit var movieNameTextView: TextView
    private lateinit var dateScrollView: HorizontalScrollView
    private lateinit var theaterListView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_theater)
        val movieName = intent.getStringExtra("MOVIE_NAME")


        movieNameTextView = findViewById(R.id.movieNameTextView)

        movieNameTextView.text = movieName


        setupDateScrollView()
        setupTheaterList()
    }

    private fun setupDateScrollView() {
        val datesContainer = findViewById<LinearLayout>(R.id.datesContainer)
        val dates = generateDates() // Create a list of dates with days

        for (date in dates) {
            val textView = TextView(this).apply {
                text = date
                setPadding(16, 16, 16, 16)
                setBackgroundResource(R.drawable.border)
                setOnClickListener {
                    Toast.makeText(this@SelectTheaterActivity, "Selected $date", Toast.LENGTH_SHORT).show()
                }
            }
            datesContainer.addView(textView)
        }
    }

    private fun setupTheaterList() {
        theaterListView = findViewById(R.id.theaterListView)
        theaterListView.layoutManager = LinearLayoutManager(this)

        // Dummy data
        val theaters = listOf(
            "Jalandhar Friends" to listOf("10:00 AM", "1:00 PM", "5:00 PM"),
            "MBD Mall Jalanadhar 2" to listOf("11:00 AM", "3:00 PM", "7:00 PM")
        )
        theaterListView.adapter = TheaterAdapter(theaters) { theater, time ->
            val intent = Intent(this, SeatSelectionActivity::class.java)
            intent.putExtra("MOVIE_NAME", movieNameTextView.text.toString())
            intent.putExtra("THEATER_NAME", theater)
            intent.putExtra("SHOW_TIME", time)
            startActivity(intent)
        }
    }

    private fun generateDates(): List<String> {
        val dates = mutableListOf<String>()
        val calendar = Calendar.getInstance()
        repeat(7) {
            val date = SimpleDateFormat("EEE, MMM d", Locale.getDefault()).format(calendar.time)
            dates.add(date)
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }
        return dates
    }
}
