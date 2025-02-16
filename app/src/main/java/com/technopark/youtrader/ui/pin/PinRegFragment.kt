package com.technopark.youtrader.ui.pin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.technopark.youtrader.R
import com.technopark.youtrader.base.BaseFragment
import com.technopark.youtrader.databinding.PinFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PinRegFragment : BaseFragment(R.layout.pin_fragment) {

    private val binding by viewBinding(PinFragmentBinding::bind)

    override val viewModel: PinRegViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Don't forget to call super.onViewCreated
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            label.text = getString(R.string.pin_reg_logo)
        }
    }

    companion object {
        const val TAG = "PinRegFragmentTag"
    }
}
