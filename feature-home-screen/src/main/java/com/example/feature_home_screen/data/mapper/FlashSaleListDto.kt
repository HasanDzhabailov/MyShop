package com.example.feature_home_screen.data.mapper


import com.example.feature_home_screen.domain.model.FlashSaleList
import com.google.gson.annotations.SerializedName

data class FlashSaleListDto(
    @SerializedName("flash_sale")
    val flash_sale: List<FlashSaleDto>
)
fun FlashSaleListDto.toFlashSaleList(): FlashSaleList = FlashSaleList(
    flash_sale.map { it.toFlashProduct() }
)
