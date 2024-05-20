package com.example.hw2_b11109031

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable

@Composable
fun MainScreen() {
    val selectedImage = remember { mutableStateOf<Pair<Int, String>?>(null) }

    if (selectedImage.value == null) {
        ImageListScreen { image ->
            selectedImage.value = image
        }
    } else {
        DetailScreen(selectedImage.value!!) {
            selectedImage.value = null
        }
    }
}