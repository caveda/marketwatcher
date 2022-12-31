package com.victorcaveda.marketwatcher.data.di

import com.victorcaveda.marketwatcher.data.repository.CryptoRepositoryImpl
import com.victorcaveda.marketwatcher.domain.repository.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindCryptoRepository(repository: CryptoRepositoryImpl): CryptoRepository
}