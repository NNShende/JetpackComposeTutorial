package com.example.jetpackcomposetutorial.network.responses

import com.example.jetpackcomposetutorial.network.model.RecipeNetworkEntity
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("results")
    var results: List<RecipeNetworkEntity> = emptyList()
)