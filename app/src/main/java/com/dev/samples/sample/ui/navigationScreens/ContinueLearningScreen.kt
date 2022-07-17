package com.dev.samples.sample.ui.navigationScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dev.samples.sample.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.samples.sample.ui.model.PackageModel
import com.skydoves.landscapist.fresco.FrescoImage

@Composable
fun ContinueLearningList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    navigateToPackage: (Int) -> Unit,
    state: LazyListState,
    listItems : List<PackageModel>
) {
    Column {
        LazyRow(
            modifier = modifier.padding(end = 16.dp),
            contentPadding = contentPadding,
            state = state
        ) {
            items(listItems) { packageData ->
                PackageCardSimple(
                    post = packageData,
                    navigateToPackage = navigateToPackage
                )
            }
        }
    }
}

@Composable
fun PackageCardSimple(
    post: PackageModel,
    navigateToPackage: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .padding(10.dp)
    ) {
        Column(modifier = Modifier.clickable(onClick = { navigateToPackage(post.packageId) })) {

            PackageImage(post)
            PackageTitle(post.title)
            StatusButton()
        }
    }
}

@Composable
fun PackageTitle(title: String) {
    Text(
        text = title,
        fontSize = 14.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
    )
}

@Composable
fun PackageImage(post: PackageModel, modifier: Modifier = Modifier) {
    FrescoImage(
        imageUrl = post.thumbnail,
        // Crop, Fit, Inside, FillHeight, FillWidth, None
        contentScale = ContentScale.FillBounds,
        // shows a placeholder ImageBitmap when loading.
        placeHolder = R.drawable.ic_book,
        // shows an error ImageBitmap when the request failed.
        error = R.drawable.ic_book,
        modifier = modifier
            .height(100.dp)
            .width(150.dp)
            .wrapContentWidth()
    )
}

@Composable
fun StatusButton() {
    Row {
        Text(
            text = "Resume", fontSize = 12.sp,
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 5.dp),
            color = colorResource(id = R.color.teal_200)
        )
    }
}
