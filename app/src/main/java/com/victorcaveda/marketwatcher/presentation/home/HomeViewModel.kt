package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorcaveda.marketwatcher.domain.model.Price
import com.victorcaveda.marketwatcher.domain.repository.CryptoRepository
import com.victorcaveda.marketwatcher.presentation.model.AssetViewData
import com.victorcaveda.marketwatcher.presentation.model.AssetsScreenData
import com.victorcaveda.marketwatcher.presentation.model.HomeState
import com.victorcaveda.marketwatcher.presentation.model.TradeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CryptoRepository) : ViewModel() {

    var state by mutableStateOf(HomeState(SampleAssetPriceData.value))
        private set

    companion object {
        private const val DEFAULT_TICKER = "ETH"
        private const val DEFAULT_CURRENCY = "EUR"
    }


    fun loadData() {
        viewModelScope.launch {
            repository.getCryptoPrice(DEFAULT_TICKER, DEFAULT_CURRENCY).fold(
                { price ->
                    state = state.copy(
                        data = price.toPresentation()
                    )
                },
                {
                    throw it // TODO Do something better
                }
            )
        }
    }
}

private fun Price.toPresentation() =
    AssetsScreenData(
        MutableList(20) {
            TradeData(ticker, "any", "$currentPrice $currency")
        }.map { AssetViewData(it, SampleAssetPriceData.fundamentals) }
    )

