package com.dudchenko.swimcounter.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dudchenko.swimcounter.ui.components.CounterBlock
import com.dudchenko.swimcounter.ui.components.ReadOnlyMetric
import com.dudchenko.swimcounter.ui.components.SectionHeader
import com.dudchenko.swimcounter.viewmodel.SessionViewModel


@Composable
fun TrainingScreen(viewModel: SessionViewModel) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp), // 16
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionHeader("TRAINING")
        ReadOnlyMetric(
            label = "Total distance",
            value = "${state.trainingDistanceMeters} m",
            valueStyle = MaterialTheme.typography.headlineLarge
        )

        HorizontalDivider()

        // ② SESSION
        SectionHeader("SESSION")
        ReadOnlyMetric(
            label = "Session distance",
            value = "${state.sessionDistanceMeters} m",
            valueStyle = MaterialTheme.typography.headlineMedium
        )
        ReadOnlyMetric(
            label = "Sets completed",
            value = state.sessionSets.toString(),
            valueStyle = MaterialTheme.typography.headlineMedium
        )

        HorizontalDivider()

        // ③ CURRENT SET (cycles)
        CounterBlock(
            title = "CURRENT SET",
            value = "${state.setDistanceMeters} m",
            minusLabel = "–50",
            plusLabel = "+50",
            minusEnabled = state.setDistanceMeters > 0,
            plusEnabled = true,
            onMinus = viewModel::removeCycle,
            onPlus = viewModel::addCycle
        )

        // ④ SET CONTROL
        CounterBlock(
            title = "SETS",
            value = state.sessionSets.toString(),
            minusLabel = "–1",
            plusLabel = "+1",
            minusEnabled = state.sessionSets > 0,
            plusEnabled = state.sessionDistanceMeters > 0,
            onMinus = viewModel::removeSet,
            onPlus = viewModel::addSet
        )

        Spacer(modifier = Modifier.weight(1f))

        // ⑤ RESET SESSION
        Button(
            onClick = viewModel::resetSession,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Text("NEXT EXERCISE")
        }
    }

}
