package com.example.feature_home_screen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.common.BaseFragment
import com.example.core.navigation_to_sreen.navigateToDeepLink
import com.example.feature_home_screen.R
import com.example.feature_home_screen.databinding.FragmentHomeBinding
import com.example.feature_home_screen.domain.model.FlashProduct
import com.example.feature_home_screen.domain.model.LatestProduct
import com.example.feature_home_screen.presentation.adapters.brands.BrandsAdapter
import com.example.feature_home_screen.presentation.adapters.categories.CategoryAdapter
import com.example.feature_home_screen.presentation.adapters.latest.LatestProductsAdapter
import com.example.feature_home_screen.presentation.adapters.sale.SaleAdapter
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
	private val homeViewModel by viewModel<HomeViewModel>()
	private var listLatestProducts: List<LatestProduct> = arrayListOf()
	private var listSaleProducts: List<FlashProduct> = arrayListOf()

	private val saleProductsAdapter: SaleAdapter by lazy {
		SaleAdapter()
	}

	private val latestProductsAdapter: LatestProductsAdapter by lazy {
		LatestProductsAdapter()
	}

	private val categoryAdapter: CategoryAdapter by lazy {
		CategoryAdapter()
	}

	private val brandsAdapter: BrandsAdapter by lazy {
		BrandsAdapter()
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		with(binding) {
			rvFlashSale.adapter = saleProductsAdapter
			rvLatest.adapter = latestProductsAdapter
			rvCategories.adapter = categoryAdapter
			rvBrands.adapter = brandsAdapter
			toolbar.setOnMenuItemClickListener {
				navigateToDeepLink(
					getString(com.example.core.R.string.profile_screen),
					this@HomeFragment
				)
				return@setOnMenuItemClickListener true
			}



		}
		homeViewModel.listLatest.observe(viewLifecycleOwner) {
			checkListLatestProducts(it.latest)
		}
		homeViewModel.listSale.observe(viewLifecycleOwner) {
			checkListSaleProducts(it.flashSale)
		}
		homeViewModel.listCategory.observe(viewLifecycleOwner) {
			categoryAdapter.submitList(it)
		}
		homeViewModel.listBrands.observe(viewLifecycleOwner){
			brandsAdapter.submitList(it)
		}
		homeViewModel.listCategoryError.observe(viewLifecycleOwner) {
			binding.root.showSnackbar(it)
		}
		homeViewModel.listLatestError.observe(viewLifecycleOwner) {
			binding.root.showSnackbar(it)
		}
		homeViewModel.listSaleError.observe(viewLifecycleOwner) {
			binding.root.showSnackbar(it)
		}
		homeViewModel.listBrandsError.observe(viewLifecycleOwner){
			binding.root.showSnackbar(it)
		}
	}

	private fun checkListSaleProducts(saleProducts: List<FlashProduct>) {
		if (saleProducts.isNotEmpty()) {
			listSaleProducts = saleProducts
			if (listLatestProducts.isNotEmpty()) {
				visibleLatestSaleProducts(true)
				latestProductsAdapter.submitList(listLatestProducts)
				saleProductsAdapter.submitList(saleProducts)
			} else {
				visibleLatestSaleProducts(false)
			}
		} else {
			visibleLatestSaleProducts(false)
		}
	}

	private fun checkListLatestProducts(productEntities: List<LatestProduct>) {
		if (productEntities.isNotEmpty()) {
			listLatestProducts = productEntities
			if (listSaleProducts.isNotEmpty()) {
				visibleLatestSaleProducts(true)
				latestProductsAdapter.submitList(productEntities)
				saleProductsAdapter.submitList(listSaleProducts)
			} else {
				visibleLatestSaleProducts(false)
			}
		} else {
			visibleLatestSaleProducts(false)
		}
	}

	private fun visibleLatestSaleProducts(visible: Boolean) {
		if (visible) {
			binding.tvLatest.visibility = View.VISIBLE
			binding.rvLatest.visibility = View.VISIBLE
			binding.tvFlashSale.visibility = View.VISIBLE
			binding.rvFlashSale.visibility = View.VISIBLE
		} else {
			binding.tvLatest.visibility = View.GONE
			binding.rvLatest.visibility = View.GONE
			binding.tvFlashSale.visibility = View.GONE
			binding.rvFlashSale.visibility = View.GONE
		}
	}

	fun View.showSnackbar(message: String) {
		Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
	}
}

