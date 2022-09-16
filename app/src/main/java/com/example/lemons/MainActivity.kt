package com.example.lemons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun LemonsApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.tap_lemon_tree),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
        )
        val image = painterResource(id = R.drawable.lemon_tree)
        Image(
            painter = image,
            contentDescription = stringResource(id = R.string.desc_lemon_tree)
        )
    }
}
