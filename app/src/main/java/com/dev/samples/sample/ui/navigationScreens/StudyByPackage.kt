package com.dev.samples.sample.ui.navigationScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.samples.sample.ui.model.PackageModel
import com.dev.samples.sample.ui.model.packageList
import com.skydoves.landscapist.fresco.FrescoImage
import com.dev.samples.sample.R

@Composable
fun StudyByPackageList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    navigateToPackage: (Int) -> Unit
) {
    Column(
        modifier = modifier.padding(end = 5.dp),
        //contentPadding = contentPadding
    ) {
        packageList.forEach {
            StudyByPackageCardSimple(
                post = it,
                navigateToPackage = navigateToPackage
            )
        }
    }

}

@Composable
fun StudyByPackageCardSimple(
    post: PackageModel,
    navigateToPackage: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = { navigateToPackage(post.packageId) }).padding(end = 16.dp)
        ) {
            StudyByPackageImage(post)
            Column(modifier = Modifier.weight(1f)) {
                StudyByPackageTitle(post.title)
            }
            StudyByPackageButton()
        }
    }
}

@Composable
fun StudyByPackageTitle(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .width(230.dp)
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
    )
}

@Composable
fun StudyByPackageImage(post: PackageModel, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = modifier.padding(0.dp),
        elevation = 0.dp
    ) {
        FrescoImage(
            imageUrl = post.thumbnail,
            // Crop, Fit, Inside, FillHeight, FillWidth, None
            contentScale = ContentScale.FillBounds,
            // shows a placeholder ImageBitmap when loading.
            placeHolder = R.drawable.ic_book,
            // shows an error ImageBitmap when the request failed.
            error = R.drawable.ic_book,
            modifier = modifier
                .height(80.dp)
                .width(80.dp)
                .wrapContentWidth()
        )
    }
}

@Composable
fun StudyByPackageButton() {
    Image(
        painterResource(R.drawable.ic_book),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(20.dp)
            .width(20.dp)
    )
}
