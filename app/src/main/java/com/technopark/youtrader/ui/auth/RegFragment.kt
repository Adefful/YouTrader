package com.technopark.youtrader.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.technopark.youtrader.R
import com.technopark.youtrader.base.BaseFragment
import com.technopark.youtrader.databinding.AuthFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegFragment : BaseFragment(R.layout.auth_fragment) {

    private val binding by viewBinding(AuthFragmentBinding::bind)

    override val viewModel: RegViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = "first.user@mail.com"
        val password = "qwerty"

        with(binding) {
            buttonSign.text = getString(R.string.sign_up)
            buttonToNextFragment.text = getString(R.string.to_sign_in)

            buttonSign.setOnClickListener {
                viewModel.signUp(email, password)
            }

            buttonToNextFragment.setOnClickListener {
                viewModel.navigateToAuthFragment()
            }
        }
    }

    companion object {
        const val TAG = "RegFragmentTag"
    }
}
