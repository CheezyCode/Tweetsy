package com.example.tweetsy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tweetsy.R

data class Item(val text: String, val color: Color)

val items = listOf<Item>(
    Item("Android", Color(0xFF1bb2b2)),
    Item("System Design", Color(0xFFff7544)),
    Item("Motivation", Color(0xFFfa5a7e)),
    Item("Facts", Color(0xFF8676fe)),
    Item("JavaScript", Color(0xFF1bb2b2)),
    Item("React", Color(0xFF4278df))
)

@Preview
@Composable
fun Simply() {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color(0xFFf8fafd))

    ) {
        Header()
        Spacer(modifier = Modifier.padding(8.dp, 0.dp))
        Grid()
        Box(modifier = Modifier.weight(1f)){
            Popular()
        }

    }
}

@Composable
fun BoxedImage(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFEEEEEE), RoundedCornerShape(8.dp))

    ) {
        content()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoxedImage {
            Image(
                imageVector = Icons.Default.Home, contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }

        Text(
            text = "Tuesday, 03 Aug",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.montserrat)),
        )
        BoxedImage {
            Image(
                imageVector = Icons.Default.Search, contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}

@Composable
fun Grid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp, 0.dp),
        content = {
            items(items) {
                GridItem(it)
            }
        })
}

@Composable
fun GridItem(category: Item) {
    Box(modifier = Modifier.padding(horizontal = 7.5.dp, vertical = 7.5.dp)) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(220.dp, 90.dp)
                .background(color = category.color)
        ) {
            Text(
                category.text,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(
                        Alignment.BottomStart
                    )
                    .padding(bottom = 10.dp, start = 10.dp)
            )
        }
    }
}

@Composable
fun Popular() {
    Column(modifier = Modifier.padding(28.dp, 32.dp)) {
        Text(
            text = "Popular Tweets",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.montserrat)),
        )
    }

}

