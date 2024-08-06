package com.serdar.inappcampaign_sdui_websocket.feature.onetoone

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.data.dto.UsersResponseItem

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
        LazyRow(
            Modifier,
        ) {
            items(listItem) { item ->
                RowItemUI(modifier, item, data)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DifferentItemsLazyColumnPreview() {
    val sampleData = listOf(
        SocketResponseItem(
            type = "YouFollow", position = 0, listItem = listOf(
                UsersResponseItem("Test", "Serdar Test 1", 10, "...."),
                UsersResponseItem("Test", "Serdar Test 2", 20, "...."),
                UsersResponseItem("Test", "Serdar Test 3", 30, "...."),
                UsersResponseItem("Test", "Serdar Test 4", 40, "....")
            )
        ),
        SocketResponseItem(
            type = "VideoMatches", position = 1, listItem = listOf(
                UsersResponseItem("Test", "Serdar Test 1", 10, "...."),
                UsersResponseItem("Test", "Serdar Test 2", 20, "...."),
                UsersResponseItem("Test", "Serdar Test 3", 30, "...."),
                UsersResponseItem("Test", "Serdar Test 4", 40, "....")
            )
        ),
        // Add more sample data as needed
    )

    DifferentItemsLazyColumn(modifier = Modifier.fillMaxSize(), data = sampleData)
}
