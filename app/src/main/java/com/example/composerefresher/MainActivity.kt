package com.example.composerefresher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.kermit)
            val title = "Cool kermit design sneaker"
            val contentDescription = "Sneakers with kermit design"

            val fontFamily = FontFamily(
                Font(R.font.poppins_black, FontWeight.Black),
                Font(R.font.poppins_black_italic, FontWeight.Black, FontStyle.Italic),
                Font(R.font.poppins_bold, FontWeight.Bold),
                Font(R.font.poppins_bold_italic, FontWeight.Bold, FontStyle.Italic),
                Font(R.font.poppins_light, FontWeight.Light),
                Font(R.font.poppins_medium, FontWeight.Medium),
            )

            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope()

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(value = textFieldState,
                        onValueChange = {
                            textFieldState = it
                        },
                        label = {
                            Text("Enter your name")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                        }
                    }) {
                        Text("Please greet me")
                    }
                }
            }

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)
//            ) {
//                ImageCard(painter = painter, contentDescription = contentDescription, title = title)
//            }

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFF101010))
//            ) {
//                Text(
//                    text = buildAnnotatedString {
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Green,
//                                fontSize = 50.sp
//                            )
//                        ) {
//                            append("S")
//                        }
//                        append("eun ")
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Green,
//                                fontSize = 50.sp
//                            )
//                        ) {
//                            append("F")
//                        }
//                        append("agade")
//                    },
//                    color = Color.White,
//                    fontSize = 30.sp,
//                    fontFamily = fontFamily,
//                    fontWeight = FontWeight.Bold,
//                    fontStyle = FontStyle.Italic,
//                    textDecoration = TextDecoration.Underline,
//                )
//            }

//            Greeting(name= "Nepa")
            
//            Column(Modifier.fillMaxSize()) {
//                val color = remember {
//                    mutableStateOf(Color.Yellow)
//                }
//
//                ColorBox(
//                    Modifier.weight(1f).fillMaxSize()
//                ) {
//                    color.value = it
//                }
//
//                Box(modifier = Modifier
//                    .background(color.value)
//                    .weight(1f)
//                    .fillMaxSize()
//                )
//            }

        }
    }
}

@Composable
fun  Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
){

    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )

            )
        }
    )
}