package com.dev.samples.sample.ui.model

import androidx.compose.runtime.Composable
import com.dev.samples.sample.R
import com.dev.samples.sample.ui.navigationScreens.BooksScreen
import com.dev.samples.sample.ui.navigationScreens.MoviesScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object Purchased : TabItem(R.drawable.ic_book, "Purchased", { MoviesScreen() })
    object Doubts : TabItem(R.drawable.ic_book, "Doubts", { MoviesScreen() })
    object Downloads : TabItem(R.drawable.ic_book, "Downloads", { BooksScreen() })
    object Bookmarks : TabItem(R.drawable.ic_book, "Bookmarks", { BooksScreen() })
}