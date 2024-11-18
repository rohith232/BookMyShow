package com.example.bookmyshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    // ViewHolder class to hold the views
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieDescription: TextView = itemView.findViewById(R.id.description)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.movieTitle.text = currentMovie.title
        holder.movieDescription.text = currentMovie.description

        val context = holder.itemView.context

        // Map the movie image name to the drawable resource ID
        val resourceId = context.resources.getIdentifier(currentMovie.imageRes, "drawable", context.packageName)
        holder.movieImage.setImageResource(resourceId)

        // Set click listeners for image and title
        val movieTitle = currentMovie.title
        val movieDescription = currentMovie.description

        holder.movieTitle.setOnClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("movie_title", movieTitle)
                putExtra("movie_description", movieDescription)
                putExtra("movie_image_resource", resourceId)  // Passing the actual resource ID here
            }
            context.startActivity(intent)
        }

        holder.movieImage.setOnClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("movie_title", movieTitle)
                putExtra("movie_description", movieDescription)
                putExtra("movie_image_resource", resourceId)  // Passing the actual resource ID here
            }
            context.startActivity(intent)
        }
    }

    // Return the size of the dataset
    override fun getItemCount() = movieList.size
}
