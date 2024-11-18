//package com.example.bookmyshow.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.bookmyshow.R
//
//class DateAdapter : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {
//
//    private var dateList = listOf<String>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_date, parent, false)
//        return DateViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
//        val date = dateList[position]
//        holder.dateTextView.text = date
//    }
//
//    override fun getItemCount(): Int {
//        return dateList.size
//    }
//
//    fun setDateList(dateList: List<String>) {
//        this.dateList = dateList
//        notifyDataSetChanged()
//    }
//
//    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
//    }
//}
