package com.example.feature_product_details_screen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.core.common.BaseFragment
import com.example.feature_product_details_screen.R
import com.example.feature_product_details_screen.databinding.FragmentProductDetailsBinding
import com.example.feature_product_details_screen.domain.model.ItemProduct
import com.example.feature_product_details_screen.presentation.adapters.color_adapter.ColorsProductAdapter
import com.example.feature_product_details_screen.presentation.adapters.images_adapter.ImagesProductAdapter
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductDetailsFragment :
	BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {
	private val productDetailsViewModel by viewModel<ProductDetailsViewModel>()

	private val imagesAdapter by lazy {
		ImagesProductAdapter()
	}

	private val colorsProductAdapter by lazy {
		ColorsProductAdapter()
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setAdapters()
		setTotalSum()
		setClickListeners()
		setObserves()
	}

	private fun removeCountProduct() {
		var currentInt = binding.tvCountProduct.text.toString().toInt()
		if (currentInt > DEFAULT_QUANTITY) {
			binding.tvCountProduct.text = (--currentInt).toString()
		} else {
			binding.tvCountProduct.text = DEFAULT_QUANTITY.toString()
		}
		setTotalSum()
	}

	private fun addCountProduct() {
		var currentInt = try {
			binding.tvCountProduct.text.toString().toInt()
		} catch (e: Exception) {
			DEFAULT_QUANTITY
		}
		binding.tvCountProduct.text = (++currentInt).toString()
		setTotalSum()
	}

	private fun setTotalSum() {
		binding.buttonCountProduct.text = String.format(
			getString(R.string.label_sum), calculateTotalSum().toString()
		)
	}

	private fun calculateTotalSum(): Int {
		val price = try {
			binding.tvPriceProduct.text.toString().removePrefix(SYMBOL_CURRENCY).replace(" ", "")
				.toInt()
		} catch (e: Exception) {
			DEFAULT_QUANTITY
		}
		val count = binding.tvCountProduct.text.toString().toInt()
		return price * count
	}

	private fun loadImageProduct(path: String) {
		Glide.with(requireContext()).load(path).centerCrop().into(binding.imageItemProduct)
	}

	private fun setAdapters() {
		binding.rvImagesProduct.adapter = imagesAdapter
		binding.rvColorsProduct.adapter = colorsProductAdapter

		imagesAdapter.clickItemImageProduct = {
			loadImageProduct(it)
		}

		colorsProductAdapter.clickItemColorProduct = {
			binding.root.showSnackbar(requireContext().getString(R.string.color_selected))
		}

	}

	private fun setClickListeners() {
		binding.buttonPlus.setOnClickListener {
			addCountProduct()
		}
		binding.buttonMinus.setOnClickListener {
			removeCountProduct()
		}




		binding.itemProductLike.setOnClickListener {
			binding.itemProductLike.setImageResource(R.drawable.ic_like_item_added_product)
		}

		binding.iconBack.setOnClickListener {
			findNavController().popBackStack()
		}
	}

	fun View.showSnackbar(message: String) {
		Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
	}

	private fun setObserves() {
		productDetailsViewModel.itemProduct.observe(viewLifecycleOwner) {
			setData(it)
		}
		productDetailsViewModel.itemProductError.observe(viewLifecycleOwner) {
			binding.root.showSnackbar(it)
		}
	}

	private fun setData(itemProduct: ItemProduct) {
		loadImageProduct(itemProduct.image_urls[0])
		imagesAdapter.submitList(itemProduct.image_urls)
		colorsProductAdapter.submitList(itemProduct.colors)
		binding.tvProductName.text = itemProduct.name
		binding.tvPriceProduct.text = String.format(
			getString(R.string.label_price_latest), itemProduct.price.toString()
		)
		binding.tvDescriptionProduct.text = itemProduct.description
		binding.tvRating.text = itemProduct.rating.toString()
		binding.tvCountReviews.text = String.format(
			getString(R.string.label_reviews), itemProduct.number_of_reviews.toString()
		)
	}

	companion object {

		const val DEFAULT_QUANTITY = 0
		const val SYMBOL_CURRENCY = "$"

	}
}