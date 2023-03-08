package com.example.feature_home_screen.presentation.adapters.sale

import androidx.recyclerview.widget.DiffUtil
import com.example.feature_home_screen.domain.model.FlashProduct

class SaleProductsDiffCallback : DiffUtil.ItemCallback<FlashProduct>() {

	override fun areItemsTheSame(
		oldItem: FlashProduct,
		newItem: FlashProduct
	): Boolean {
		return oldItem.image_url == newItem.image_url
	}

	override fun areContentsTheSame(
		oldItem: FlashProduct,
		newItem: FlashProduct,
	): Boolean {
		return oldItem == newItem
	}
}