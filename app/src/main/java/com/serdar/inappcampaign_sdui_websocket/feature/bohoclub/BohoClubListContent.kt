package com.serdar.inappcampaign_sdui_websocket.feature.bohoclub

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.data.dto.UsersResponseItem

@Composable
fun BohoClubEventContent(
    modifier: Modifier, listItem: List<UsersResponseItem>,
) {
    val colors = listOf(Color.Red, Color.Blue, Color.Green, Color.Yellow)

    Card(
        modifier, colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        LazyRow(
            Modifier.padding(10.dp),
        ) {
            items(listItem) { item ->
                BohoClubEventItem(modifier, item, colors.random())
            }
        }
    }
}


@Composable
@Preview
fun TestingApp() {
    val sampleData = listOf(
        SocketResponseItem(
            type = "YouFollow", position = 4, listItem = listOf(
                UsersResponseItem(
                    "\uD83D\uDCF8 Best Video Matches",
                    "Serdar Test 1",
                    10,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "\uD83D\uDCF8 Best Video Matches",
                    "Serdar Test 2",
                    20,
                    "https://i.hizliresim.com/tlq6r9z.png"
                ),
                UsersResponseItem(
                    "\uD83D\uDCF8 Best Video Matches",
                    "Serdar Test 3",
                    30,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "\uD83D\uDCF8 Best Video Matches",
                    "Serdar Test 4",
                    40,
                    "https://i.hizliresim.com/tlq6r9z.png"
                )
            )
        ),
        SocketResponseItem(
            type = "VideoMatches", position = 1, listItem = listOf(
                UsersResponseItem(
                    "\uD83D\uDC64 Users You Follow",
                    "Serdar Test 1",
                    10,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "\uD83D\uDC64 Users You Follow",
                    "Serdar Test 2",
                    20,
                    "https://i.hizliresim.com/tlq6r9z.png"
                ),
                UsersResponseItem(
                    "\uD83D\uDC64 Users You Follow",
                    "Serdar Test 3",
                    30,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "\uD83D\uDC64 Users You Follow",
                    "Serdar Test 4",
                    40,
                    "https://i.hizliresim.com/tlq6r9z.png"
                )
            )
        ),
        SocketResponseItem(
            type = "MostPopular", position = 1, listItem = listOf(
                UsersResponseItem(
                    "\uD83E\uDD0D Most Popular",
                    "Serdar Test 1",
                    10,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "\uD83E\uDD0D Most Popular",
                    "Serdar Test 2",
                    20,
                    "https://i.hizliresim.com/tlq6r9z.png"
                ),
                UsersResponseItem(
                    "\uD83E\uDD0D Most Popular",
                    "Serdar Test 3",
                    30,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "\uD83E\uDD0D Most Popular",
                    "Serdar Test 4",
                    40,
                    "https://i.hizliresim.com/tlq6r9z.png"
                )
            )
        ),
        SocketResponseItem(
            type = "Empty", position = 0, listItem = listOf(
                UsersResponseItem(
                    "Empty Data View",
                    "Serdar Test 1",
                    10,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "Empty Data View",
                    "Serdar Test 2",
                    20,
                    "https://i.hizliresim.com/tlq6r9z.png"
                ),
                UsersResponseItem(
                    "Empty Data View",
                    "Serdar Test 3",
                    30,
                    "https://i.hizliresim.com/s4p0zb1.png"
                ),
                UsersResponseItem(
                    "Empty Data View",
                    "Serdar Test 4",
                    40,
                    "https://i.hizliresim.com/tlq6r9z.png"
                )
            )
        )
        // Add more sample data as needed
    )
    BohoClubEventContent(Modifier, sampleData.first().listItem)
}