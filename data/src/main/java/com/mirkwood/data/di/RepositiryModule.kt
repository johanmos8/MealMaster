package com.mirkwood.data.di

import com.mirkwood.data.networking.ApiService
import com.mirkwood.data.repository.CategoryRepositoryImpl
import com.mirkwood.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCategoryRepository(
        apiService: ApiService
    ): CategoryRepository = CategoryRepositoryImpl(apiService)

}