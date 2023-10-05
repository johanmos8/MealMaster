package com.mirkwood.domain.inspector

import com.mirkwood.domain.model.Category
import com.mirkwood.domain.util.Resource
import kotlinx.coroutines.flow.Flow


interface GetCategoriesUseCase {
    suspend operator fun invoke(): Flow<Resource<List<Category>>>
}