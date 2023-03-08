package com.example.feature_home_screen.presentation.adapters.categories

import androidx.recyclerview.widget.DiffUtil
import com.example.feature_home_screen.domain.model.ItemCategory

class CategoryDiffCallback : DiffUtil.ItemCallback<ItemCategory>() {
	override fun areItemsTheSame(oldItem: ItemCategory, newItem: ItemCategory): Boolean {
		return oldItem.name == newItem.name
	}

	override fun areContentsTheSame(oldItem: ItemCategory, newItem: ItemCategory): Boolean {
		return oldItem == newItem
	}
}