package com.example.composenav.ui.element

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(buttonText: String, onButtonClick: () -> Unit) {
    Button(
        modifier = Modifier.padding(16.dp),
        onClick = { onButtonClick() }
    ) {
        Text(buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview() {
    ActionButton(buttonText = "Hello", onButtonClick = {})
}