package com.serdar.inappcampaign_sdui_websocket.feature.chart


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.serdar.inappcampaign_sdui_websocket.ui.theme.BlueBean
import com.serdar.inappcampaign_sdui_websocket.ui.theme.GreenBean


@Composable
fun RowScope.BarChart(
    size: Dp, max: Float, onDialogOpen: () -> Unit
) {
    var height by remember { mutableStateOf(0.dp) }
    val heightAnim by animateDpAsState(
        targetValue = height,
        tween(durationMillis = 2000, delayMillis = 300, easing = LinearEasing),
        label = ""
    )

    LaunchedEffect(key1 = size) {
        height = size
    }
    Box(
        modifier = Modifier
            .padding(start = 3.dp, bottom = 0.dp, end = 3.dp, top = 3.dp)
            .size(heightAnim)
            .clip(
                RoundedCornerShape(
                    10.dp
                )
            )
            .weight(1f)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        BlueBean, GreenBean
                    )
                )
            )
            .clickable {
                onDialogOpen.invoke()
            }
    ) {

    }
}

@Composable
fun BarChartView() {
    val state = remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .size(300.dp)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {

        Column(
            modifier = Modifier.size(400.dp),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Connected Time",
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(10.dp)

            )
            val daily = listOf(
                "06:00:00",
                "06:00:00",
                "05:10:10",
                "00:00:00",
                "00:00:00",
                "00:00:00",
                "00:00:00"
            )
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(20.dp),
//                verticalAlignment = Alignment.Bottom,
//                horizontalArrangement = Arrangement.Start
//
//            ) {
//                daily.forEach {
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .width(10.dp), contentAlignment = Center
//                    ) {
//                        Text(text = it)
//                    }
//                }
//            }
            val values = mutableListOf(50.dp, 100.dp, 250.dp, 75.dp, 100.dp, 90.dp, 85.dp)
            val labels = listOf("Pzt", "Sal", "Çar", "Per", "Cum", "Cts", "Paz")

            Row(
                modifier = Modifier.height(200.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Start
            ) {
                values.forEach {
                    values.maxOfOrNull { it.value }?.let { value ->
                        BarChart(it, value, onDialogOpen = {
                            state.value = false

                        })
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Start

            ) {
                labels.forEach {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .width(10.dp), contentAlignment = Center
                    ) {
                        Text(text = it)
                    }
                }
            }

        }
    }
    LaunchedEffect(key1 = state) {

    }
    if (state.value) {
        InfoDialog(
            onDismissRequest = {
                state.value = false
            }
        )
    }


}

@Composable
fun InfoDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .height(150.dp)
                .width(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(200.dp)
                    .padding(16.dp),
            ) {
                Text(
                    text = "Connected Time",
                    modifier = Modifier
                        .wrapContentSize(Center)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "02:00:01",
                    modifier = Modifier
                        .wrapContentSize(Center)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "You Earn: 50",
                    modifier = Modifier
                        .wrapContentSize(Center)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                )
            }

        }
    }
}

@Preview
@Composable
fun TestTask() {

}