package com.mirkwood.data.mapper

import com.mirkwood.data.networking.model.CategoryDTO
import com.mirkwood.domain.model.Category

fun List<CategoryDTO>.toDomain(): List<Category>    {
    return this.map {
        Category(
            idCategory = it.idCategory,
            strCategory = it.strCategory,
            strCategoryThumb = it.strCategoryThumb,
            strCategoryDescription = it.strCategoryDescription
        )
    }
}