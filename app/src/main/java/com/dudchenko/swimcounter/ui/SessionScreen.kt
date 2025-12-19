package com.dudchenko.swimcounter.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dudchenko.swimcounter.ui.components.CounterBlock
import com.dudchenko.swimcounter.viewmodel.SessionViewModel


@Composable
fun SessionScreen(viewModel: SessionViewModel) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        // Distance block
        CounterBlock(
            title = "Distance",
            value = "${state.distanceMeters} m",
            onPlus = viewModel::addCycle,
            onMinus = viewModel::removeCycle
        )

        // Sets block
        CounterBlock(
            title = "Sets",
            value = state.sets.toString(),
            onPlus = viewModel::addSet,
            onMinus = viewModel::removeSet
        )

        Text(text = "Total distance: ${state.totalDistance} m", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.weight(1f))

        // Reset button
        Button(
            onClick = viewModel::resetSession,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Reset session")
        }
    }
}
