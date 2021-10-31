package com.example.jetpackcomposetutorial.di

import com.example.jetpackcomposetutorial.network.model.RecipeDtoMapper
import com.example.jetpackcomposetutorial.network.services.RecipeService
import com.example.jetpackcomposetutorial.repository.RecipeRepository
import com.example.jetpackcomposetutorial.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeService, recipeDtoMapper)
    }
}