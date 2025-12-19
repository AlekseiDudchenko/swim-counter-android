package com.dudchenko.swimcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dudchenko.swimcounter.ui.TrainingScreen
import com.dudchenko.swimcounter.viewmodel.SessionViewModel

import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: SessionViewModel = viewModel()
            TrainingScreen(viewModel)
        }
    }
}
