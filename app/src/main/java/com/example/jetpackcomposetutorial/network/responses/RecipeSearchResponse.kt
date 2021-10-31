package com.example.jetpackcomposetutorial.network.responses

import com.example.jetpackcomposetutorial.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("results")
    var recipes: List<RecipeDto> = emptyList()
)