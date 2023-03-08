package com.example.feature_home_screen.presentation.adapters.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.feature_home_screen.databinding.ItemCategoryBinding
import com.example.feature_home_screen.domain.model.ItemCategory

class CategoryAdapter : ListAdapter<ItemCategory, CategoryViewHolder>(CategoryDiffCallback()) {

	var clickItemCategory: ((ItemCategory) -> Unit)? = null

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
		val binding = ItemCategoryBinding.inflate(
			LayoutInflater.from(parent.context),
			parent,
			false
		)
		return CategoryViewHolder(binding)
	}

	override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
		val itemCategory = getItem(position)
		val binding = holder.binding
		val context = binding.root.context

		binding.root.setOnClickListener {
			clickItemCategory?.invoke(itemCategory)
		}

		Glide.with(context).load(itemCategory.img).into(binding.iconCategory)
		binding.tvNameCategory.text = itemCategory.name

	}
}