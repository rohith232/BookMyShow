package com.example.bookmyshow


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.bookmyshow.MoviesAdapter
import com.example.bookmyshow.R.layout.activity_main

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewMovies: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        // Initialize RecyclerView
        recyclerViewMovies = findViewById(R.id.recyclerViewMovies)
        recyclerViewMovies.layoutManager = LinearLayoutManager(this)
        // Set up adapter with dummy data or actual data source
         recyclerViewMovies.adapter = MoviesAdapter(getMovieList())

        // Set onClick listeners for category items
        findViewById<TextView>(R.id.tvMovies).setOnClickListener {
            val intent = Intent(this, LanguageSelectionActivity::class.java)
            startActivity(intent)

            // Navigate to Movies or update RecyclerView content
            Toast.makeText(this, "Movies category selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.sports).setOnClickListener {
            Toast.makeText(this, "Sports category selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.tvComedyShows).setOnClickListener {
            Toast.makeText(this, "Comedy Shows category selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.tvMusicShows).setOnClickListener {
            Toast.makeText(this, "Music Shows category selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.tvStandup).setOnClickListener {
            Toast.makeText(this, "Standup category selected", Toast.LENGTH_SHORT).show()
        }
        findViewById<ImageView>(R.id.Movies1).setOnClickListener{
            val intent = Intent(this, LanguageSelectionActivity::class.java)
            startActivity(intent)

            // Navigate to Movies or update RecyclerView content
            Toast.makeText(this, "Movies category selected", Toast.LENGTH_SHORT).show()


        }
        findViewById<TextView>(R.id.Movies2).setOnClickListener{
            val intent = Intent(this, LanguageSelectionActivity::class.java)
            startActivity(intent)

            // Navigate to Movies or update RecyclerView content
            Toast.makeText(this, "Movies category selected", Toast.LENGTH_SHORT).show()


        }
    }


    //Recommmended  Movies
    private fun getMovieList(): List<Movie> {
        // Return a list of movie objects, either dummy or real data
        return listOf(
            Movie("RRR", "A Telugu movie about freedom fighters.", "movie_image_1", "Telugu"),
            Movie("Pushpa", "A Telugu action drama.", "movie_image_2", "Telugu"),
            Movie("K.G.F-2", "A malayalam movie about the rise of a gangster.", "movie_image_3", "Malayalam"),
            Movie("Dangal", "A Hindi movie about a wrestler's journey.", "movie_image_5", "Hindi"),
            Movie("3 Idiots", "A Hindi movie about three friends.", "movie_image_6", "Hindi"),
            Movie("Vikram", "A Tamil action movie.", "movie_image_7", "Tamil"),
            Movie("Inception", "subconscious", "movie_image_1", "English"),

            )
    }
}
