package com.dudchenko.swimcounter.ui.components
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterBlock(
    title: String,
    value: String,
    minusLabel: String,
    plusLabel: String,
    minusEnabled: Boolean,
    plusEnabled: Boolean,
    onMinus: () -> Unit,
    onPlus: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
        Text(text = value, style = MaterialTheme.typography.displaySmall)

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onMinus,
                enabled = minusEnabled,
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
            ) {
                Text(minusLabel)
            }

            // plus button
            Button(
                onClick = onPlus,
                enabled = plusEnabled,
                modifier = Modifier
                    .weight(2f)
                    .height(80.dp)
            ) {
                Text(plusLabel)
            }
        }
    }
}
