package com.example.feature_home_screen.presentation.adapters.brands

import androidx.recyclerview.widget.DiffUtil
import com.example.feature_home_screen.domain.model.ItemBrand

class BrandsDiffCallback : DiffUtil.ItemCallback<ItemBrand>() {

	override fun areItemsTheSame(oldItem: ItemBrand, newItem: ItemBrand): Boolean {
		return oldItem.img == newItem.img
	}

	override fun areContentsTheSame(oldItem: ItemBrand, newItem: ItemBrand): Boolean {
		return oldItem == newItem
	}
}