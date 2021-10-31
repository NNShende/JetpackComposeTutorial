package com.example.jetpackcomposetutorial.repository

import com.example.jetpackcomposetutorial.domain.model.Recipe
import com.example.jetpackcomposetutorial.network.model.RecipeDtoMapper
import com.example.jetpackcomposetutorial.network.services.RecipeService

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }
}