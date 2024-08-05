package com.serdar.inappcampaign_sdui_websocket.feature.onetoone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serdar.inappcampaign_sdui_websocket.R
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.data.dto.UsersResponseItem
import com.serdar.inappcampaign_sdui_websocket.feature.ViewScreenType

@Composable
fun DifferentItemsLazyColumn(modifier: Modifier = Modifier, data: List<SocketResponseItem>) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(data) { item ->
            DifferentItemsContent(Modifier, item.listItem, item)
        }
    }

}

@Composable
fun EmptyData() {
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



@Composable
fun DifferentItemsContent(
    modifier: Modifier, listItem: List<UsersResponseItem>, data: SocketResponseItem
) {
    Card(
        Modifier.padding(5.dp), colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = listItem.first().title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )
        Divider(
            Modifier.padding(bottom = 10.dp), color = Color(0xFFD1D8DD)
        )
        LazyRow(Modifier
        ,) {
            items(listItem) { item ->
                RowItemUI(modifier, item, data)
            }
        }
    }
}

@Composable
fun RowItemUI(modifier: Modifier, childList: UsersResponseItem, data: SocketResponseItem) {

    if (data.type=="Empty"){
        EmptyData()
    }else{
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

@Preview(showBackground = true)
@Composable
fun DifferentItemsLazyColumnPreview() {
    val sampleData = listOf(
        SocketResponseItem(
            type = "YouFollow",
            position = 0,
            listItem = listOf(
                UsersResponseItem("Test","Serdar Test 1", 10,"...."),
                UsersResponseItem("Test","Serdar Test 2", 20,"...."),
                UsersResponseItem("Test","Serdar Test 3", 30,"...."),
                UsersResponseItem("Test","Serdar Test 4", 40,"....")
            )
        ),
        SocketResponseItem(
            type = "VideoMatches",
            position = 1,
            listItem = listOf(
                UsersResponseItem("Test","Serdar Test 1", 10,"...."),
                UsersResponseItem("Test","Serdar Test 2", 20,"...."),
                UsersResponseItem("Test","Serdar Test 3", 30,"...."),
                UsersResponseItem("Test","Serdar Test 4", 40,"....")
            )
        ),
        // Add more sample data as needed
    )

    DifferentItemsLazyColumn(modifier = Modifier.fillMaxSize(), data = sampleData)
}
