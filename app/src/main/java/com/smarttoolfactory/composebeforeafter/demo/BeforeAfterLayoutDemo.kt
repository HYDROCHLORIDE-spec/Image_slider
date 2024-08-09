package com.smarttoolfactory.composebeforeafter.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.beforeafter.BeforeAfterLayout
import com.smarttoolfactory.beforeafter.OverlayStyle

@Composable
fun BeforeAfterLayoutDemo(before: ImageBitmap, after: ImageBitmap) {
    // Create a vertical scroll state
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally, // Center items horizontally
        verticalArrangement = Arrangement.Center // Center items vertically
    ) {
        // Center the BeforeAfterLayout within the Column
        Box(
            modifier = Modifier
                .shadow(1.dp, RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .aspectRatio(4 / 3f)
        ) {
            BeforeAfterLayout(
                modifier = Modifier
                    .fillMaxSize(), // Make sure BeforeAfterLayout fills its container
                beforeContent = {
                    DemoImage(imageBitmap = before)
                },
                afterContent = {
                    DemoImage(imageBitmap = after)
                },
                overlayStyle = OverlayStyle(
                    dividerColor = Color(0xffF44336),
                    dividerWidth = 2.dp,
                    thumbShape = CutCornerShape(8.dp),
                    thumbBackgroundColor = Color.Red,
                    thumbTintColor = Color.White,
                ),
            )
        }
    }
}

@Composable
fun DemoImage(imageBitmap: ImageBitmap) {
    Image(
        bitmap = imageBitmap,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

