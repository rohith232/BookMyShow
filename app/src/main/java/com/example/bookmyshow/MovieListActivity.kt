package com.example.bookmyshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieListActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewMovies)

        // Set the layout manager to GridLayoutManager (2 columns in this example)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        // Get the selected language from the intent
        val selectedLanguage = intent.getStringExtra("selected_language") ?: "English"

        // Display the selected language in the TextView
        val languageTextView: TextView = findViewById(R.id.languageTextView)
        languageTextView.text = "$selectedLanguage Movies:"

        // Example movie data with languages
        val allMovies = listOf(
            Movie("RRR", "A Telugu movie about freedom fighters.", "movie_image_1", "Telugu"),
            Movie("Pushpa", "A Telugu action drama.", "movie_image_2", "Telugu"),
            Movie("Bahubali", "An epic Telugu movie about a kingdom.", "movie_image_4", "Telugu"),
            Movie("Idiot", "An epic Telugu movie about a Character.", "movie_image_4", "Telugu"),


            Movie("K.G.F", "A Kannada movie about the rise of a gangster.", "movie_image_3", "Malayalam"),
            Movie("yatra-2", "An epic politics movie about a kingdom.", "movie_image_4", "Malayalam"),
            Movie("K.G.F-2", "A malayalam movie about the rise of a gangster.", "movie_image_3", "Malayalam"),

            Movie("Dangal", "A Hindi movie about a wrestler's journey.", "movie_image_5", "Hindi"),
            Movie("3 Idiots", "A Hindi movie about three friends.", "movie_image_6", "Hindi"),
            Movie("Dangal", "A Hindi movie about a wrestler's journey.", "movie_image_5", "Hindi"),
            Movie("3 Idiots", "A Hindi movie about three friends.", "movie_image_6", "Hindi"),


            Movie("Vikram", "A Tamil action movie.", "movie_image_7", "Tamil"),
            Movie("Gajini", "A Tamil action movie.", "movie_image_7", "Tamil"),


                    Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.\n" +
                            "\n" +
                            "Director\n" +
                            "Christopher Nolan\n" +
                            "Writer\n" +
                            "Christopher Nolan", "inception", "English"),
        Movie("GOT", "game of thrones", "got", "English"),
            Movie("Iron Man", "Season 2 explores the Armor Wars saga and Stane International storylines. Tony Stark and Rhodey, as War Machine, battle various enemies who have stolen Stark’s armor tech and seek to exploit it for their own purposes.", "ironman", "English"),




            )

        // Filter movies based on the selected language
        val filteredMovies = allMovies.filter { it.language == selectedLanguage }

        // If no movies match the selected language, show all movies as a fallback
        val moviesToDisplay = if (filteredMovies.isNotEmpty()) filteredMovies else allMovies

        // Set the adapter with the filtered list
        val adapter = MoviesAdapter(moviesToDisplay)
        recyclerView.adapter = adapter
    }
}
