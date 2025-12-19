package com.dudchenko.swimcounter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterBlock(
    title: String,
    value: String,
    onPlus: () -> Unit,
    onMinus: () -> Unit
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
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onMinus,
                modifier = Modifier.weight(1f)
            ) {
                Text("–")
            }

            Button(
                onClick = onPlus,
                modifier = Modifier.weight(1f)
            ) {
                Text("+")
            }
        }
    }
}
