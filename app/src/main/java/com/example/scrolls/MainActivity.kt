package com.example.scrolls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrolls.ui.theme.ScrollsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {

    private val listItems: List<ElementsForOneRow> = listOf(
        ElementsForOneRow("isOk","Jayme"),
        ElementsForOneRow("isNot","Gil"),
        ElementsForOneRow("not","Juice WRLD"),
        ElementsForOneRow("Ok","Callan"),
        ElementsForOneRow("Ok","Braxton"),
        ElementsForOneRow("Ok","Kyla"),
        ElementsForOneRow("Ok","Lil Mosey"),
        ElementsForOneRow("Ok","Allan"),
        ElementsForOneRow("Ok","Mike"),
        ElementsForOneRow("Ok","Drew"),
        ElementsForOneRow("Ok","SDFNia"),
        ElementsForOneRow("Ok","Coi Relay"),
        ElementsForOneRow("Ok","CGGGallan"),
        ElementsForOneRow("Not","Braxton"),
        ElementsForOneRow("Ok","TTTKyla"),
        ElementsForOneRow("Ok","Lil Mosey"),
        ElementsForOneRow("Not","ADllan"),
        ElementsForOneRow("Ok","Mike"),
        ElementsForOneRow("N","Drew"),
        ElementsForOneRow("Ok","VBGNia"),
        ElementsForOneRow("Not","DSHCoi Relay")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DisplayList(items = listItems)
                }
            }
        }
    }
}

@Composable
fun DisplayList(items: List<ElementsForOneRow>) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        items(items) { item ->
            ElementsForOneRow(item = item)
        }
        CoroutineScope(Dispatchers.Main).launch {
            listState.scrollToItem(items.size - 1)
        }
    }

}

@Composable
fun ElementsForOneRow(item: ElementsForOneRow) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
            .height(60.dp)
            .background(color = Color.Gray)
    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.scanning_ending),
                contentDescription = "user icon",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(CenterVertically)
                    .width(80.dp)
                    .height(80.dp)
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(CenterVertically),
                text = item.isOk,
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(CenterVertically),
                text = item.name,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ScrollsTheme {
        ElementsForOneRow(item = ElementsForOneRow("isOk" ,name = String()))
    }
}
