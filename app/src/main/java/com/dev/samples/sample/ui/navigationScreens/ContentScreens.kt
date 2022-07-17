package com.dev.samples.sample.ui.navigationScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.samples.sample.R
import androidx.navigation.NavController
import com.dev.samples.sample.theme.Blue30
import com.dev.samples.sample.theme.Blue80
import com.dev.samples.sample.ui.model.packageList
import com.dev.samples.sample.ui.widgets.DotsIndicator

@Composable
fun MyContentScreen(navController: NavController) {
    val listItems = remember { packageList.toMutableStateList() }

    val state = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
    ) {
        item { SectionTitle(title = "Continue Learning") }
        item { ContinueLearningList(state = state, navigateToPackage = {
            navController.navigate(errorScreen)
        }, listItems = listItems) }
        item { Spacer(modifier = Modifier.height(20.dp)) }
        item {
            DotsIndicator(
                totalDots = if(packageList.size - 2 > 15) 15 else packageList.size - 2,
                selectedIndex = if(state.firstVisibleItemIndex > 15) 15 else state.firstVisibleItemIndex,
                selectedColor = Blue30,
                unSelectedColor = Blue80
            )
        }
        item { SectionTitle(title = "Study by Packages") }
        item { StudyByPackageList {
            navController.navigate(errorScreen)
        } }
        item { SectionTitle(title = "Study  by Product") }
        item { BottomSection(navController) }
        item { Spacer(modifier = Modifier.height(20.dp)) }
    }
}


@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black,
        fontSize = 18.sp ,
        modifier = Modifier.padding(start = 10.dp, top = 15.dp)
    )
}


/*@Preview("Simple package card")
@Preview("Simple package card (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SimplePostPreview() {
    SampleOverAllTheme {
        Surface {
            PackageCardSimple(packageList[0], {})
        }
    }
}*/

/*
@Preview(showBackground = true)
@Composable
fun MusicScreenPreview() {
    MyContentScreen()
}
*/

@Composable
fun MoviesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Movies View",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Composable
fun BooksScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Books View",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}
