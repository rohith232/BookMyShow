package com.example.bookmyshow.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmyshow.R
import com.example.bookmyshow.Theater

class TheaterAdapter(
    private val theaters: List<Pair<String, List<String>>>,
    private val onTimeClick: (String, String) -> Unit
) : RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder>() {

    class TheaterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val theaterName: TextView = itemView.findViewById(R.id.theaterName)
        val timingsContainer: LinearLayout = itemView.findViewById(R.id.timingsContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheaterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.theater_item, parent, false)
        return TheaterViewHolder(view)
    }

    override fun onBindViewHolder(holder: TheaterViewHolder, position: Int) {
        val (theaterName, timings) = theaters[position]
        holder.theaterName.text = theaterName

        holder.timingsContainer.removeAllViews()
        for (time in timings) {
            val timeView = TextView(holder.itemView.context).apply {
                text = time
                setPadding(8, 8, 8, 8)
                setBackgroundResource(R.drawable.border)
                setOnClickListener {
                    onTimeClick(theaterName, time)
                }
            }
            holder.timingsContainer.addView(timeView)
        }
    }

    override fun getItemCount(): Int = theaters.size
}
