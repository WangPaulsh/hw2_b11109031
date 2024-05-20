package com.example.hw2_b11109031

import android.content.Context
import android.widget.ImageButton
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val imageList = listOf(
    Pair(R.drawable.image1, "台北101"),
    Pair(R.drawable.image2, "行天宮"),
    Pair(R.drawable.image3, "松山文創園區")
)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DetailScreen(image: Pair<Int, String>, onBack: () -> Unit) {
    var currentIndex by remember { mutableStateOf(imageList.indexOf(image)) }
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onBack) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .height(30.dp),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box (
            modifier = Modifier
                .size(300.dp, 300.dp)
                .shadow(10.dp)
        ) {
            Image(
                painter = painterResource(id = imageList[currentIndex].first),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box (modifier = Modifier
            .padding(horizontal = 16.dp)
            .size(250.dp, 70.dp)
            .background(color = Color(220, 220, 255))
        ) {
            Text(
                text = imageList[currentIndex].second,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                uriHandler.openUri("geo:0,0?q=${imageList[currentIndex].second}")
            },
            modifier = Modifier.pointerInteropFilter {
                when (it.action) {
                    android.view.MotionEvent.ACTION_DOWN -> {
                    }
                }
                false
            }
        ) {
            Text("View on Map")
        }
    }
}