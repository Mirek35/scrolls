package com.example.scrolls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime

data class ElementsForOneRow(val isOk: String, val name: String, val mdata: LocalDateTime) {
}

@Composable
fun ElementsForOneRow(item: ElementsForOneRow) {
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Box(
            Modifier
                .width(60.dp)
                .height(60.dp)
                .padding(2.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center

        ) {
            this@Row.PaintStatusIcon(item)
        }
        Box(
            Modifier
                .width(120.dp)
                .height(60.dp)
                .padding(2.dp)
                .background(Color.White),
            contentAlignment = Alignment.Center,


        ) {
            this@Row.Name(item)
        }
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .padding(2.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            this@Row.Time(item)
        }

    }
}

@Composable
private fun RowScope.Time(item: ElementsForOneRow) {
    Text(
        text = convertTimeToHumanReadableFormat(item.mdata),
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}

@Composable
private fun RowScope.Name(item: ElementsForOneRow) {
    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        text = item.name,
        color = Color.Black,
        fontSize = 12.sp
    )
}

@Composable
private fun RowScope.IsElementOk(item: ElementsForOneRow) {
    Text(
//        modifier = Modifier
//            .padding(horizontal = 16.dp)
//            .align(Alignment.CenterVertically),
        text = item.isOk,
        color = Color.Black,
        fontSize = 12.sp
    )
}

