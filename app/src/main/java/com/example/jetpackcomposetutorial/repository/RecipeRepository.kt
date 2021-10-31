package com.example.jetpackcomposetutorial.repository

import com.example.jetpackcomposetutorial.domain.model.Recipe

interface RecipeRepository {
    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe
}