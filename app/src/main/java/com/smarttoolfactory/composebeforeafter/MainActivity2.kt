package com.smarttoolfactory.composebeforeafter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.imageResource
import com.smarttoolfactory.composebeforeafter.demo.BeforeAfterLayoutDemo

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val view = findViewById<ComposeView>(R.id.main)
        view.setContent {
            val beforeImage = ImageBitmap.imageResource(id = R.drawable.image_before_after_shoes_b)
            val afterImage = ImageBitmap.imageResource(id = R.drawable.image_before_after_shoes_a)

            MaterialTheme {
                BeforeAfterLayoutDemo(beforeImage, afterImage)
            }
        }


    }
}
