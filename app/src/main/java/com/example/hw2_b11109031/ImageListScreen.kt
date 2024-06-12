package com.example.hw2_b11109031

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw2_b11109031.ui.theme.Hw2_b11109031Theme

@Composable
fun ImageListScreen(onImageSelected: (Pair<Int, String>) -> Unit) {
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(imageList) { image ->
            Spacer(modifier = Modifier.height(20.dp))

            Box (
                    modifier = Modifier
                        .size(300.dp, 75.dp)
                        .shadow(1.dp)
            ) {
                Text(
                    text = image.second,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { onImageSelected(image) },
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

