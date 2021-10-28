package com.technopark.youtrader.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.technopark.youtrader.R
import com.technopark.youtrader.databinding.AuthFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment(R.layout.auth_fragment) {

    private val binding by viewBinding(AuthFragmentBinding::bind)

    private val viewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val email = "first.user@mail.com"
        val password = "qwerty"

        with(binding) {
            buttonSignIn.setOnClickListener {
                viewModel.signIn(email, password)
            }

            buttonCheckSignIn.setOnClickListener {
                viewModel.checkSignIn(email)
            }

            buttonSignUp.setOnClickListener {
                viewModel.signUp(email, password)
            }

            buttonSignOut.setOnClickListener {
                viewModel.signOut()
            }

            button.setOnClickListener {
                val navController =
                    parentFragmentManager.findFragmentById(R.id.nav_host_fragment)
                        ?.findNavController()
                navController?.navigate(AuthFragmentDirections.actionFirstFragmentToSecondFragment())
            }
        }

        viewModel.cryptoCurrencies.observe(
            viewLifecycleOwner,
            { currencies ->
                Log.d(TAG, "Received: ${currencies.first()}")
                Toast.makeText(
                    requireContext(),
                    "Received: ${currencies.first()}",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        )
        viewModel.getCryptoCurrencies()
    }

    companion object {
        const val TAG = "FirstFragmentTag"
    }
}
