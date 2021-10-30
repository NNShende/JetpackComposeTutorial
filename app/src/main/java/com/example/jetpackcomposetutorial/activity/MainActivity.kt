package com.example.jetpackcomposetutorial.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackcomposetutorial.R
import com.example.jetpackcomposetutorial.fragment.RecipeListFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}