package com.serdar.inappcampaign_sdui_websocket.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serdar.inappcampaign_sdui_websocket.R
import com.serdar.inappcampaign_sdui_websocket.ui.theme.BlueFirst
import com.serdar.inappcampaign_sdui_websocket.ui.theme.OrangeButton
import com.serdar.inappcampaign_sdui_websocket.ui.theme.PinkButton
import com.serdar.inappcampaign_sdui_websocket.ui.theme.PinkFirst
import com.serdar.inappcampaign_sdui_websocket.ui.theme.PinkTime
import com.serdar.inappcampaign_sdui_websocket.ui.theme.RedTime

@Composable
fun CardContent(modifier: Modifier = Modifier) {
    val linerGradientBrush = Brush.linearGradient(
        colors = listOf(
            RedTime, PinkTime
        )
    )
    Box(
        modifier = Modifier.fillMaxWidth()

    ) {
        Box(modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .graphicsLayer {
                shape = CustomCardShape()
                clip = true
            }
            .height(250.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(PinkFirst, BlueFirst)
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_diamond1),
                    contentDescription = "Your Image",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(100.dp)
                )
                Text(
                    text = "messageText",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .padding(top = 60.dp)
                )
                Text(
                    text = "messageText",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(alignment = Alignment.BottomStart)
                        .padding(start = 40.dp, bottom = 40.dp)
                )

            }
        }
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 50.dp, top = 10.dp)
                .size(80.dp, 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Red,
            ),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(linerGradientBrush)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "12 | 00 |12",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

        }
        val linerGradientBrushButton = Brush.linearGradient(
            colors = listOf(
                OrangeButton, PinkButton
            )
        )
        Button(modifier = Modifier
            .align(Alignment.BottomEnd)
            .size(150.dp, 30.dp)
            .padding(end = 50.dp, bottom = 5.dp)
            .clip(CircleShape),
            contentPadding = PaddingValues(),
            onClick = { }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(linerGradientBrushButton)
                    .clip(CircleShape), contentAlignment = Alignment.Center
            ) {
                Text(text = "69,99", color = White)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewGradientCardScreen() {
    CardContent()
}