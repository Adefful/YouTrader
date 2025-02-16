package com.technopark.youtrader.ui.pin

import com.technopark.youtrader.base.BaseViewModel
import com.technopark.youtrader.network.auth.IAuthService
import com.technopark.youtrader.repository.CryptoCurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PinAuthViewModel @Inject constructor(
    private val repository: CryptoCurrencyRepository,
    private val authService: IAuthService
) : BaseViewModel() {

    fun navigateToCurrenciesFragment() {
        val someString = "Random text"
    }
}
