package com.example.feature_home_screen.presentation.adapters.brands

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.feature_home_screen.R
import com.example.feature_home_screen.databinding.ItemBrandsBinding
import com.example.feature_home_screen.domain.model.ItemBrand

class BrandsAdapter : ListAdapter<ItemBrand, BrandsViewHolder>(BrandsDiffCallback()) {

	var clickItemBrand: ((ItemBrand) -> Unit)? = null

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandsViewHolder {
		val binding = ItemBrandsBinding.inflate(
			LayoutInflater.from(parent.context),
			parent,
			false
		)
		return BrandsViewHolder(binding)
	}

	override fun onBindViewHolder(holder: BrandsViewHolder, position: Int) {
		val itemBrand = getItem(position)
		val binding = holder.binding
		val context = binding.root.context

		binding.root.setOnClickListener {
			clickItemBrand?.invoke(itemBrand)
		}

		Glide.with(context).load(itemBrand.img)
			.into(binding.imageBrand)

	}
}