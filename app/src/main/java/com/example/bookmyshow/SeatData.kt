package com.example.bookmyshow

data class SeatData(
    val seatNumber: Int,
    val category: String,
    val price: Int,
    var isSelected: Boolean = false  // Track selection status
)
