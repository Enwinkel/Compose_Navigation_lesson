package com.stasst.composenavigationlesson.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen() {
    val testArray = listOf("Hello", "Stas", "Maybe", "Something", "New value", "Hello", "Stas", "Maybe", "Something", "New value")

    Scaffold { padding ->
        LazyColumn {
            testArray.map {item {Text(it, modifier = Modifier.padding(24.dp))}}
        }
    }
}
