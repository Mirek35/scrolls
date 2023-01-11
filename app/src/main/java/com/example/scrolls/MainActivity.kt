package com.example.scrolls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
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
import androidx.compose.material.MaterialTheme as MaterialTheme1

class MainActivity : ComponentActivity() {

    private val listItems: List<ElementsForOneRow> = listOf(
        ElementsForOneRow("isOk", "Jayme", LocalDateTime.now()),
        ElementsForOneRow("isNot", "Gifl", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("not", "WRLD", LocalDateTime.now().minusDays(6)),
        ElementsForOneRow("Ok", "Caln", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Brton", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok", "Kyla", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Liley", LocalDateTime.now().minusHours(1)),
        ElementsForOneRow("Ok", "Allan", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok", "Mike", LocalDateTime.now().minusDays(4)),
        ElementsForOneRow("Ok", "Drew", LocalDateTime.now().minusHours(4)),
        ElementsForOneRow("Ok", "SDNia", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok", "CoiRelay", LocalDateTime.now().minusDays(8)),
        ElementsForOneRow("Ok", "CGGlan", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Not", "Brton", LocalDateTime.now().minusHours(7)),
        ElementsForOneRow("Ok", "TKyla", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Liley", LocalDateTime.now().minusHours(3)),
        ElementsForOneRow("Not", "ADlan", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Mike", LocalDateTime.now().minusHours(5)),
        ElementsForOneRow("N", "Drew", LocalDateTime.now().minusHours(3)),
        ElementsForOneRow("Ok", "VBNia", LocalDateTime.now().minusDays(7)),
        ElementsForOneRow("Not", "DReay", LocalDateTime.now().minusHours(1))

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme1.colors.background
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
    Column(
        Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color.Blue),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Text(text = "Example", fontSize = 44.sp)

        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize(1f)
        ) {
            items(items) { item ->
                ElementsForOneRow(item = item)
            }
            CoroutineScope(Dispatchers.Main).launch {
                listState.scrollToItem(items.size - 1)
            }
        }
    }
    }
}

@Composable
fun ElementsForOneRow(item: ElementsForOneRow) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
            .height(50.dp)
            .background(color = Color.Gray)
    ) {

        Row(
            modifier = Modifier
                .align(BottomCenter)
                .padding(horizontal = 8.dp)
                .fillMaxWidth()

        ) {
            if (item.isOk=="Ok"){
                Icon(
                    painter = painterResource(R.drawable.scanning_ending),
                    modifier = Modifier
                        .size(80.dp)
                        .padding(horizontal = 8.dp)
                        .align(CenterVertically)
                    , tint = Color.Unspecified,
                    contentDescription =""
                )
            }else
                Icon(
                    painter = painterResource(R.drawable.scanning_error),
                    modifier = Modifier
                        .size(80.dp)
                        .padding(horizontal = 8.dp)
                        .align(CenterVertically)
                    , tint = Color.Unspecified,
                    contentDescription =""
                )


            Text(modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(CenterVertically),
                text = item.isOk,
                color = Color.Black,
                fontSize = 12.sp)
            Text(modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(CenterVertically),
                text = item.name,
                color = Color.Black,
                fontSize = 12.sp)

            Text(modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(CenterVertically)
                ,text = convertTimeToHumanReadableFormat(item.mdata),
                fontSize = 12.sp,
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
        ElementsForOneRow(item = ElementsForOneRow("isOk", String(), LocalDateTime.now()))
    }
}
