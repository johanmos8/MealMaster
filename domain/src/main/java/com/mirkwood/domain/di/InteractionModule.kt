package com.mirkwood.domain.di

import com.mirkwood.domain.inspector.GetCategoriesUseCase
import com.mirkwood.domain.inspector.GetCategoriesUseCaseImpl
import com.mirkwood.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InteractionModule {
    @Provides
    fun provideGetCategoriesUseCase(
        categoryRepository: CategoryRepository
    ): GetCategoriesUseCase = GetCategoriesUseCaseImpl(categoryRepository)

}