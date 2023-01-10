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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrolls.ui.theme.ScrollsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {

    private val listItems: List<ElementsForOneRow> = listOf(
        ElementsForOneRow("isOk","Jayme", LocalDateTime.now()),
       ElementsForOneRow("isNot","Gil", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("not","Juice WRLD", LocalDateTime.now().minusDays(6)),
        ElementsForOneRow("Ok","Callan", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok","Braxton", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok","Kyla", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok","Lil Mosey", LocalDateTime.now().minusHours(1)),
        ElementsForOneRow("Ok","Allan", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok","Mike", LocalDateTime.now().minusDays(4)),
        ElementsForOneRow("Ok","Drew", LocalDateTime.now().minusHours(4)),
        ElementsForOneRow("Ok","SDFNia", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok","Coi Relay", LocalDateTime.now().minusDays(8)),
        ElementsForOneRow("Ok","CGGGallan", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Not","Braxton", LocalDateTime.now().minusHours(7)),
        ElementsForOneRow("Ok","TTTKyla", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok","Lil Mosey", LocalDateTime.now().minusHours(3)),
        ElementsForOneRow("Not","ADllan", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok","Mike", LocalDateTime.now().minusHours(5)),
        ElementsForOneRow("N","Drew", LocalDateTime.now().minusHours(3)),
        ElementsForOneRow("Ok","VBGNia", LocalDateTime.now().minusDays(7)),
        ElementsForOneRow("Not","D Relay", LocalDateTime.now().minusHours(1))

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
            Text(modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(CenterVertically),
                text = item.isOk,
                color = Color.Black,
                fontSize = 16.sp)
            Text(modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(CenterVertically),
                text = item.name,
                color = Color.Black,
                fontSize = 16.sp)
            Text(modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(CenterVertically)
                ,text = convertTimeToHumanReadableFormat(item.mdata),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
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
        ElementsForOneRow(item = ElementsForOneRow("isOk" ,String(),LocalDateTime.now()))
    }
}
