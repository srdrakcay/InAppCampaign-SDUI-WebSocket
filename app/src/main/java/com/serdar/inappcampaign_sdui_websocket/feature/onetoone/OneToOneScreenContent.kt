package com.serdar.inappcampaign_sdui_websocket.feature.onetoone

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.serdar.inappcampaign_sdui_websocket.feature.bohoclub.BohoClubEventContent

@Composable
fun DifferentItemsLazyColumn(
    modifier: Modifier = Modifier,
    data: List<SocketResponseItem>,
    sample: List<SocketResponseItem>,
    onVoiceClick: () -> Unit,
    onVideoClick: () -> Unit
) {

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {

        itemsIndexed(sample) { index, item ->
            if (index == 0) {
                BohoClubEventContent(
                    Modifier,
                    item.listItem
                )
            }

            DifferentItemsContent(Modifier, item.listItem, item, onVoiceClick, onVideoClick)
        }

    }


}

@Composable
fun DifferentItemsContent(
    modifier: Modifier,
    listItem: List<UsersResponseItem>,
    data: SocketResponseItem,
    onVoiceClick: () -> Unit,
    onVideoClick: () -> Unit
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
                RowItemUI(modifier.fillMaxSize(), item, data, onVoiceClick, onVideoClick)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DifferentItemsLazyColumnPreview() {


}
