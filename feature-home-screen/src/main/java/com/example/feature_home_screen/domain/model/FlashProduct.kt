package com.example.feature_home_screen.domain.model

data class FlashProduct(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double,
)