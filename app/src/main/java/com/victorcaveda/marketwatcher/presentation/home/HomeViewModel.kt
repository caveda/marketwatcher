package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorcaveda.marketwatcher.domain.model.Price
import com.victorcaveda.marketwatcher.domain.repository.CryptoRepository
import com.victorcaveda.marketwatcher.presentation.model.HomeState
import com.victorcaveda.marketwatcher.presentation.model.PriceScreenData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CryptoRepository) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    companion object {
        private const val DEFAULT_TICKER = "ETH"
        private const val DEFAULT_CURRENCY = "EUR"
        private val DEFAULT_HOME_STATE = HomeState(PriceScreenData(DEFAULT_TICKER, "-"))
    }

    init {
        state = DEFAULT_HOME_STATE.copy()
    }

    fun loadData() {
        viewModelScope.launch {
            repository.getCryptoPrice(DEFAULT_TICKER, DEFAULT_CURRENCY).fold(
                { price ->
                    state = state.copy(
                        assetPrice = price.toPresentation()
                    )
                },
                {
                    state = DEFAULT_HOME_STATE.copy()
                })
        }
    }
}

private fun Price.toPresentation() =
    PriceScreenData(ticker, "$currentPrice $currency")

