package com.technopark.youtrader.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.technopark.youtrader.R
import com.technopark.youtrader.base.BaseFragment
import com.technopark.youtrader.databinding.ProfileFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment(R.layout.profile_fragment) {

    private val binding by viewBinding(ProfileFragmentBinding::bind)

    override val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonBack.setOnClickListener {
                viewModel.navigateToCurrenciesFragment()
            }
            buttonNext.setOnClickListener {
                viewModel.navigateToWithoutBottomNavViewFragment()
            }
            buttonChart.setOnClickListener {
                viewModel.navigateToChartFragment()
            }
            buttonPortfolio.setOnClickListener {
                viewModel.navigateToPortfolioFragment()
            }
        }
    }
}
