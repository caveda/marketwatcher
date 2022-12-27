package com.victorcaveda.marketwatcher.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorcaveda.marketwatcher.data.repository.CryptoRepositoryImpl
import com.victorcaveda.marketwatcher.domain.model.Price
import com.victorcaveda.marketwatcher.presentation.model.HomeState
import com.victorcaveda.marketwatcher.presentation.model.PriceScreenData
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val cryptoRepository = CryptoRepositoryImpl()

    var state by mutableStateOf(HomeState())
        private set

    fun loadData() {
        viewModelScope.launch {
            cryptoRepository.getCryptoPrice("any").fold(
                { price ->
                    state = state.copy(
                        assetPrice = price.toPresentation()
                    )
                }, {})
        }
    }
}

private fun Price.toPresentation() =
    PriceScreenData("$currentPrice $currency")

