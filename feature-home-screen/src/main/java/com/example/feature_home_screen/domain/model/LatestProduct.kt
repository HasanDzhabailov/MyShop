package com.example.feature_home_screen.domain.model

import java.util.*


data class LatestProduct(
    val id: UUID,
    val category: String,
    val image_urls: String,
    val name: String,
    val price: Int
)

