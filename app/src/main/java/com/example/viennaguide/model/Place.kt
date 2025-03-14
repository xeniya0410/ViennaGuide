package com.example.viennaguide.model

import androidx.annotation.DrawableRes

data class Place(
    val id: Int,
    val name: String,
    val category: String,
    val description: String,
    val rating: Float,
    @DrawableRes val imageRes: Int
)
