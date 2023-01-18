package com.example.scrolls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrolls.ui.theme.ScrollsTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import androidx.compose.material.MaterialTheme as MaterialTheme1

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val phoneModel = PhoneModel()
        setContent {
            ScrollsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme1.colors.background
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    ) {
                        TopScreen()
                        BottomScreen(items = phoneModel.listItems)
                    }
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.TopScreen() {
    Row(
        Modifier
            .fillMaxWidth()
            .weight(2f)
            .background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = "Example", fontSize = 44.sp)
    }
}

@Composable
private fun ColumnScope.BottomScreen(
    items: List<ElementsForOneRow>
) {
    Row(
        Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Transparent),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(1f)

        ) {
            items(items) { item ->
                ElementsForOneRow(item = item)
            }
        }
    }
}

fun convertTimeToHumanReadableFormat(timeToBeFormatted: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm")
    return timeToBeFormatted.format(formatter)

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ScrollsTheme {
        ElementsForOneRow(item = ElementsForOneRow("isOk", String(), LocalDateTime.now()))
    }
}
