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
        // Включить если включен вход по PIN и наоборот...
        //TODO switchPinCode.isChecked =

            buttonBack.setOnClickListener {
                viewModel.navigateToCurrenciesFragment()
            }
            buttonNext.setOnClickListener {
                viewModel.navigateToWithoutBottomNavViewFragment()
            }
            switchPinCode.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    //TODO Включить вход по PIN
                    viewModel.navigateToPinRegFragment()
                } else {
                    //TODO Выключить вход по PIN

                }
            }
        }
    }
}
