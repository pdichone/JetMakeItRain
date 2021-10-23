package com.bawp.introtocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bawp.introtocompose.ui.theme.IntroToComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    val moneyCounter = remember {
        mutableStateOf(0)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(), color = Color(0xFF546E7A)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
              ) {
            Text(text = "$${moneyCounter.value}", style = TextStyle(
                    color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold))

            Spacer(modifier = Modifier.height(130.dp))

              CreateCircle(moneyCounter = moneyCounter.value) { newValue ->
                   moneyCounter.value = newValue
              }

            if (moneyCounter.value > 25) {
                 Text("Lots of money!")
            }
        }
    }

}

//@Preview
@Composable
fun CreateCircle(moneyCounter: Int = 0,
                 updateMoneyCounter: (Int) -> Unit ) {

    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
                   updateMoneyCounter(moneyCounter + 1)
        }, shape = CircleShape, elevation = 4.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap", modifier = Modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        MyApp()

    }
}