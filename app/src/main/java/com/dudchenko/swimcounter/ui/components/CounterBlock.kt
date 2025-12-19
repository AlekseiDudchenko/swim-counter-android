package com.dudchenko.swimcounter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CounterBlock(
    title: String,
    value: String,
    onPlus: () -> Unit,
    onMinus: () -> Unit,
    plusButtonText: String = "+1",
    plusButtonSize: Dp = 120.dp
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = value,
            style = MaterialTheme.typography.displayMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onMinus,
                modifier = Modifier.height(56.dp)
            ) {
                Text("-1")
            }

            Button(
                onClick = onPlus,
                modifier = Modifier.size(plusButtonSize),
                shape = CircleShape
            ) {
                Text(plusButtonText, style = MaterialTheme.typography.displayMedium)
            }
        }
    }
}
