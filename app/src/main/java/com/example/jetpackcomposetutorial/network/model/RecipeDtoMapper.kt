package com.example.jetpackcomposetutorial.network.model

import com.example.jetpackcomposetutorial.domain.model.Recipe
import com.example.jetpackcomposetutorial.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.primaryKey,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featuredImage,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients,
            dateAdded = model.dateAdded, // Depending on API, may need to format date
            dateUpdated = model.dateUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            primaryKey = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated
        )
    }

    fun fromEntityList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map {
            mapToDomainModel(it)
        }
    }

    fun toEntityList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map {
            mapFromDomainModel(it)
        }
    }

}