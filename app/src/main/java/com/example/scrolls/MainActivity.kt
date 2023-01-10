package com.example.scrolls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scrolls.ui.theme.ScrollsTheme

class MainActivity : ComponentActivity() {

    private val listItems: List<ListItem> = listOf(
        ListItem("Jayme"),
        ListItem("Gil"),
        ListItem("Juice WRLD"),
        ListItem("Callan"),
        ListItem("Braxton"),
        ListItem("Kyla"),
        ListItem("Lil Mosey"),
        ListItem("Allan"),
        ListItem("Mike"),
        ListItem("Drew"),
        ListItem("Nia"),
        ListItem("Coi Relay")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    DisplayList(items = listItems)
                }
            }
        }
    }
}

@Composable
fun DisplayList(items: List<ListItem>) {

    val listState = rememberLazyListState()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScrollsTheme {
        DisplayList("Android")
    }
}