package com.mirkwood.domain.inspector

import com.mirkwood.domain.model.Category
import com.mirkwood.domain.repository.CategoryRepository
import com.mirkwood.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCaseImpl @Inject constructor(
    val categoryRepository: CategoryRepository
) : GetCategoriesUseCase {
    override suspend fun invoke(): Flow<Resource<List<Category>>> {
        return categoryRepository.getCategories()
    }
}