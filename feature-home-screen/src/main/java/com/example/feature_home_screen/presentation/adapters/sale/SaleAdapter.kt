package com.example.feature_home_screen.presentation.adapters.sale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.feature_home_screen.R
import com.example.feature_home_screen.databinding.ItemSaleBinding
import com.example.feature_home_screen.domain.model.FlashProduct

class SaleAdapter :
	ListAdapter<FlashProduct, SaleProductViewHolder>(SaleProductsDiffCallback()) {

	var clickItemSaleProduct: ((FlashProduct) -> Unit)? = null

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleProductViewHolder {
		val binding = ItemSaleBinding.inflate(
			LayoutInflater.from(parent.context),
			parent,
			false
		)
		return SaleProductViewHolder(binding)
	}

	override fun onBindViewHolder(holder: SaleProductViewHolder, position: Int) {
		val itemSaleProduct = getItem(position)
		val binding = holder.binding
		val context = binding.root.context

		binding.root.setOnClickListener {
			clickItemSaleProduct?.invoke(itemSaleProduct)
		}

		Glide.with(context).load(itemSaleProduct.image_url)
			.centerCrop()
			.into(
				binding.imageSale
			)

		binding.tvCategoryItem.text = itemSaleProduct.category
		binding.tvItemName.text = itemSaleProduct.name
		binding.tvPrice.text = String.format(
			context.getString(R.string.label_price_latest),
			itemSaleProduct.price
		)
		binding.tvDiscount.text = String.format(
			context.getString(R.string.label_discount),
			itemSaleProduct.discount
		)
	}
}