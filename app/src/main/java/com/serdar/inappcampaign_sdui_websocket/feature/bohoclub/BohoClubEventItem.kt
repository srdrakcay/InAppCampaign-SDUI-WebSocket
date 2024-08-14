package com.serdar.inappcampaign_sdui_websocket.feature.bohoclub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.serdar.inappcampaign_sdui_websocket.data.dto.UsersResponseItem

@Composable
fun BohoClubEventItem(
    modifier: Modifier,
    childList: UsersResponseItem,
    backgroundColor: Color
) {
    Box(
        Modifier
            .height(160.dp)
            .width(160.dp)
            .padding(horizontal = 4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = childList.userName,
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(childList.userImage)
                .crossfade(true).build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(90.dp)
                .width(90.dp)
                .padding(top = 5.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )

    }
}