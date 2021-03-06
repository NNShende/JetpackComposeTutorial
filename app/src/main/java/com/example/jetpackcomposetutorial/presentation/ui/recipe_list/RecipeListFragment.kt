package com.example.jetpackcomposetutorial.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.jetpackcomposetutorial.R
import com.example.jetpackcomposetutorial.presentation.components.FoodCategoryChip
import com.example.jetpackcomposetutorial.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeListFragment: Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value

                val query = viewModel.query.value

                val selectedCategory = viewModel.selectedCategory.value

                Column {
                    Surface(
                        elevation = 8.dp,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            // Search Row
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TextField(
                                    value = query,
                                    onValueChange = { newValue ->
                                        viewModel.onQueryChanged(newValue)
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(8.dp),
                                    label = {
                                        Text(text = context.getString(R.string.search_text))
                                    },
                                    keyboardOptions = KeyboardOptions(
                                        capitalization = KeyboardCapitalization.Sentences,
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Search
                                    ),
                                    leadingIcon = {
                                        Icon(Icons.Filled.Search)
                                    },
                                    onImeActionPerformed = { action, softKeyboardController ->
                                        if (action == ImeAction.Search) {
                                            viewModel.newSearch()
                                            softKeyboardController?.hideSoftwareKeyboard()
                                        }
                                    },
                                    textStyle = TextStyle(
                                        color = MaterialTheme.colors.onSurface
                                    ),
                                    backgroundColor = MaterialTheme.colors.surface
                                )
                            }

                            // Search Chips
                            val scrollState = rememberScrollState()
                            ScrollableRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                scrollState = scrollState,
                            ) {
                                scrollState.scrollTo(viewModel.categoryScrollPosition)
                                for(category in getAllFoodCategories()) {
                                    FoodCategoryChip(
                                        category = category.value,
                                        isSelected = selectedCategory == category,
                                        onExecuteSearch = viewModel::newSearch,
                                        onSelectedCategoryChanged = {
                                            viewModel.onChangeCategoryScrollPosition(scrollState.value)
                                            viewModel.onSelectedCategoryChanged(it)
                                        }
                                    )
                                }
                            }
                        }
                    }

                    // List of recipes
                    LazyColumn{
                        itemsIndexed(
                            items = recipes
                        ){ index, recipe ->
                            RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }
            }
        }
    }
}