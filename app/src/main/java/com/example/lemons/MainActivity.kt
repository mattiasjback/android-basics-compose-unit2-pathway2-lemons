package com.example.lemons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemons.ui.theme.LemonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonsTheme {
                LemonsApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonsTheme {
        LemonsApp()
    }
}

private val lemonResources =  mapOf(
    1 to Pair(R.drawable.lemon_tree, R.string.tap_lemon_tree),
    2 to Pair(R.drawable.lemon_squeeze, R.string.keep_tapping_lemon),
    3 to Pair(R.drawable.lemon_drink, R.string.tap_lemonade),
    4 to Pair(R.drawable.lemon_restart, R.string.tap_empty_glass)
)

@Composable
fun LemonsApp() {

    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    val resources = lemonResources[currentStep]!!

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(currentStep) {
            1 -> LemonTextAndImage(
                imageId = resources.first,
                textId = resources.second,
                onImageClick = {
                    currentStep++
                    squeezeCount = (1..4).random()
                }
            )
            2 -> LemonTextAndImage(
                imageId = resources.first,
                textId = resources.second,
                onImageClick = {
                    squeezeCount--
                    if(squeezeCount == 0) {
                        currentStep++
                    }
                }
            )
            3 -> LemonTextAndImage(
                imageId = resources.first,
                textId = resources.second,
                onImageClick = {
                    currentStep++
                }
            )
            4 -> LemonTextAndImage(
                imageId = resources.first,
                textId = resources.second,
                onImageClick = {
                    currentStep = 1
                }
            )
        }
    }
}

@Composable
fun LemonTextAndImage(
    imageId: Int,
    textId: Int,
    onImageClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = textId),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
        )
        val image = painterResource(id = imageId)
        Image(
            painter = image,
            contentDescription = "click the lemon",
            modifier = Modifier.clickable {
                onImageClick()
            }
        )
    }
}