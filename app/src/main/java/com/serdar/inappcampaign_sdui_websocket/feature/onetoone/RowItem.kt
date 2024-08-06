package com.serdar.inappcampaign_sdui_websocket.feature.onetoone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.data.dto.UsersResponseItem

@Composable
fun RowItemUI(modifier: Modifier, childList: UsersResponseItem, data: SocketResponseItem) {

    if (data.type == "Empty") {
        EmptyDataContent()
    } else {
        Box(
            Modifier
                .height(200.dp)
                .width(160.dp)
                .padding(horizontal = 4.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xF1201E1F))
        ) {
            GetImageFromCoil(
                childList.userImage
            )
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 5.dp, top = 5.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_voice),
                    contentDescription = "Voice Icon",
                    modifier = Modifier
                        .size(25.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_video),
                    contentDescription = "Video Icon",
                    modifier = Modifier
                        .size(25.dp)
                        .clip(CircleShape)
                )
            }
            Row(modifier = Modifier.align(Alignment.BottomStart)) {

                GetImageFromCoilMini(
                    imageUrl = childList.userImage,
                    modifier
                        .size(38.dp)
                        .padding(8.dp)
                        .clip(CircleShape),
                )

                Text(
                    modifier = Modifier.padding(8.dp),
                    text = childList.userName,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }

}