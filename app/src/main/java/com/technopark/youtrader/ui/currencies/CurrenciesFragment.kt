package com.technopark.youtrader.ui.currencies

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.technopark.youtrader.R
import com.technopark.youtrader.base.BaseFragment
import com.technopark.youtrader.databinding.CurrenciesFragmentBinding
import com.technopark.youtrader.model.CurrencyItem
import com.technopark.youtrader.model.Result
import com.technopark.youtrader.utils.VerticalItemDecoration
import com.technopark.youtrader.utils.gone
import com.technopark.youtrader.utils.visible
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.currencies_fragment.*

@AndroidEntryPoint
class CurrenciesFragment : BaseFragment(R.layout.currencies_fragment) {

    private val binding by viewBinding(CurrenciesFragmentBinding::bind)
    override val viewModel: CurrenciesViewModel by viewModels()
    private val adapter by lazy { GroupieAdapter() }

    private val onItemClickListener = OnItemClickListener { item, view ->
        if (item is CurrencyItem) {
            Log.d(TAG, "Go to currency: ${item.currency.name}")
            viewModel.navigateToChartFragment(item.currency.id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            currenciesRecyclerView.adapter = adapter
            currenciesRecyclerView.addItemDecoration(
                VerticalItemDecoration(
                    resources.getDimension(R.dimen.indent_tiny).toInt()
                )
            )
        }

        adapter.setOnItemClickListener(onItemClickListener)

        viewModel.screenState.observe(
            viewLifecycleOwner,
            { screenState ->
                when (screenState) {
                    is Result.Success -> {
                        with(binding) {
                            progressBar.gone()
                            currencies_recycler_view.visible()
                        }
                        adapter.update(screenState.data)
                    }
                    is Result.Loading -> {
                        with(binding) {
                            progressBar.visible()
                            currencies_recycler_view.gone()
                        }
                    }
                    is Result.Error -> {
                        // TODO parse error
                        Toast.makeText(
                            requireContext(),
                            screenState.exception.message,
                            Toast.LENGTH_SHORT
                        ).show()
                        screenState.exception.message?.let { Log.d(TAG, it) }
                        binding.progressBar.gone()
                    }
                }
            }
        )

        search.addTextChangedListener {
            viewModel.updateCurrenciesByMatch(binding.search.text.toString())
        }
    }

    companion object {
        private const val TAG = "CurrenciesFragment"
    }
}
