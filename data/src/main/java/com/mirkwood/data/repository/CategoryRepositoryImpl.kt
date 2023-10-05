package com.mirkwood.data.repository

import com.mirkwood.data.mapper.toDomain
import com.mirkwood.data.networking.ApiService
import com.mirkwood.data.util.CATEGORIES
import com.mirkwood.domain.model.Category
import com.mirkwood.domain.repository.CategoryRepository
import com.mirkwood.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CategoryRepository {
    override suspend fun getCategories(): Flow<Resource<List<Category>>> {
        return flow {
            emit(Resource.loading())
            try {
                val response = apiService.getCategories(
                    CATEGORIES
                )
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.success(it.categories.toDomain()))
                    }
                } else {
                    emit(Resource.success(emptyList()))
                }

            } catch (e: Exception) {
                emit(Resource.error(e.message ?: "An unknown error occurred"))
            }
        }
    }
}