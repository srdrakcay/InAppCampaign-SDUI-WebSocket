package com.serdar.inappcampaign_sdui_websocket.feature.onetoone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serdar.inappcampaign_sdui_websocket.R

@Composable
fun EmptyDataContent() {
    Box(
        Modifier
            .height(200.dp)
            .width(400.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Row içindeki öğeleri dikeyde ortalar
        ) {
            Text(
                text = "You are not currently following anyone. When you follow the user you want, you will be able to see it here!",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.empty_view),
                contentDescription = "Logo",
                modifier = Modifier
                    .weight(1f)
                    .height(400.dp) // Görüntü için sabit yükseklik belirler
            )
        }
    }
}