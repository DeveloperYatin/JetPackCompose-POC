package com.dev.samples.sample.ui.navigationScreens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dev.samples.sample.R
import com.dev.samples.sample.ui.widgets.ShimmerEffectScreen
import kotlinx.coroutines.delay

/**
 * Full screen circular progress indicator
 */
@Composable
fun FullScreenLoading(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }

    val scale = remember { Animatable(0f) }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        delay(1000L)
        navController.navigate(mainScreen)
    }
}

@Composable
fun ShimmerScreenLoading(navController: NavController) {
    ShimmerEffectScreen()

    val scale = remember { Animatable(0f) }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        delay(1000L)
        navController.navigate(mainScreen)
    }
}

@Composable
fun ErrorScreen(onRetryClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.ic_no_result),
                contentDescription = null, // decorative
                contentScale = ContentScale.Crop,
                modifier = Modifier.wrapContentSize()
            )

            Text(
                text = "You have no purchased items\n" + "to show",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(top = 15.dp)
            )

            Button(
                onClick = { onRetryClick.invoke() },
                modifier = Modifier
                    .padding(28.dp)
                    .height(40.dp)
                    .width(200.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(android.graphics.Color.parseColor("#FC3A52")),
                    contentColor = MaterialTheme.colors.surface
                )
            ) {
                Text(text = "TAKE ME TO STORE", fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun BottomSection(navController: NavController) {
    val data = listOf("Live Classes", "Test Series", "Video Courses", "E Books")
    Row(modifier = Modifier.padding(start = 10.dp,end = 10.dp,top = 10.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            SectionButtons(data[0],navController)
        }
        Column(modifier = Modifier.weight(1f)) {
            SectionButtons(data[1],navController)
        }
    }
    Row(modifier = Modifier.padding(start = 10.dp,end = 10.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            SectionButtons(data[2],navController)
        }
        Column(modifier = Modifier.weight(1f)) {
            SectionButtons(data[3],navController)
        }
    }
}

@Composable
fun SectionButtons(text: String,navController: NavController) {
    Button(
        onClick = { navController.navigate(errorScreen) }, modifier = Modifier
            .padding(4.dp)
            .height(60.dp)
            .width(200.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp),
                tint = Color.Cyan
            )
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen { }
}