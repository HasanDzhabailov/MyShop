package com.example.feature_home_screen.presentation.adapters.latest

import androidx.recyclerview.widget.DiffUtil
import com.example.feature_home_screen.domain.model.LatestProduct

class LatestProductsDiffCallback : DiffUtil.ItemCallback<LatestProduct>() {

	override fun areItemsTheSame(oldItem: LatestProduct, newItem: LatestProduct): Boolean {
		return oldItem.id == newItem.id
	}

	override fun areContentsTheSame(oldItem: LatestProduct, newItem: LatestProduct): Boolean {
		return oldItem == newItem
	}
}