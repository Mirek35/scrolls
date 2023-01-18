package com.example.scrolls

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrolls.ui.theme.ScrollsTheme

@Composable
fun RowScope.PaintStatusIcon(item: ElementsForOneRow) {
    if (item.isOk == "Ok") {
        DrawIcon(R.drawable.scanning_ending)
    } else
        DrawIcon(R.drawable.scanning_error)
}

@Composable
private fun RowScope.DrawIcon(iconToRender: Int) {
    Icon(
        painter = painterResource(iconToRender),
        modifier = Modifier
            .size(80.dp)
            .padding(horizontal = 8.dp)
            .align(Alignment.CenterVertically), tint = Color.Unspecified,
        contentDescription = ""
    )
}

