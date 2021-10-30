package com.example.jetpackcomposetutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.example.jetpackcomposetutorial.customview.HorizontalDottedProgress

class RecipeListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = "This is a Title", color = Color.Blue, textAlign = TextAlign.Center)
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .border(1.dp, Color.Black),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "THIS IS A COMPOSABLE INSIDE THE FRAGMENT")
                    Spacer(modifier = Modifier.padding(10.dp))
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = "Neat")
                    Spacer(modifier = Modifier.padding(10.dp))
                    val customView = HorizontalDottedProgress(AmbientContext.current)
                    AndroidView(viewBlock = {customView})
                }
            }
        }
    }
}