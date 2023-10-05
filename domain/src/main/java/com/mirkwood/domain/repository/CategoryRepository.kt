package com.mirkwood.domain.repository

import com.mirkwood.domain.model.Category
import com.mirkwood.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<Resource<List<Category>>>
}