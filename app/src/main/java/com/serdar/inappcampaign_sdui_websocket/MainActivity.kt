package com.serdar.inappcampaign_sdui_websocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.data.dto.UsersResponseItem
import com.serdar.inappcampaign_sdui_websocket.feature.bohoclub.BohoClubEventContent
import com.serdar.inappcampaign_sdui_websocket.feature.bohoclub.BohoClubSceen
import com.serdar.inappcampaign_sdui_websocket.feature.onetoone.OneToOneScreen
import com.serdar.inappcampaign_sdui_websocket.ui.theme.InAppCampaignSDUIWebSocketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InAppCampaignSDUIWebSocketTheme {
                val sampleData = listOf(
                    SocketResponseItem(
                        type = "YouFollow", position =4 , listItem = listOf(
                            UsersResponseItem(
                                "\uD83D\uDCF8 Best Video Matches",
                                "Bugün 21:00 de Ayşe ile Live",
                                10,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "\uD83D\uDCF8 Best Video Matches",
                                "Bugün 21:00 de Ayşe ile Live",
                                20,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            ),
                            UsersResponseItem(
                                "\uD83D\uDCF8 Best Video Matches",
                                "Bugün 21:00 de Ayşe ile Live",
                                30,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "\uD83D\uDCF8 Best Video Matches",
                                "Bugün 21:00 de Ayşe ile Live",
                                40,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            )
                        )
                    ),
                    SocketResponseItem(
                        type = "VideoMatches", position = 1, listItem = listOf(
                            UsersResponseItem(
                                "\uD83D\uDC64 Users You Follow",
                                "Bugün 21:00 de Ayşe ile Live",
                                10,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "\uD83D\uDC64 Users You Follow",
                                "Bugün 21:00 de Ayşe ile Live",
                                20,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            ),
                            UsersResponseItem(
                                "\uD83D\uDC64 Users You Follow",
                                "Bugün 21:00 de Ayşe ile Live",
                                30,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "\uD83D\uDC64 Users You Follow",
                                "Bugün 21:00 de Ayşe ile Live",
                                40,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            )
                        )
                    ),
                    SocketResponseItem(
                        type = "MostPopular", position = 1, listItem = listOf(
                            UsersResponseItem(
                                "\uD83E\uDD0D Most Popular",
                                "Bugün 21:00 de Ayşe ile Live",
                                10,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "\uD83E\uDD0D Most Popular",
                                "Bugün 21:00 de Ayşe ile Live",
                                20,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            ),
                            UsersResponseItem(
                                "\uD83E\uDD0D Most Popular",
                                "Bugün 21:00 de Ayşe ile Live",
                                30,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "\uD83E\uDD0D Most Popular",
                                "Bugün 21:00 de Ayşe ile Live",
                                40,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            )
                        )
                    ),
                    SocketResponseItem(
                        type = "Empty", position = 0, listItem = listOf(
                            UsersResponseItem(
                                "Empty Data View",
                                "Bugün 21:00 de Ayşe ile Live",
                                10,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "Empty Data View",
                                "Bugün 21:00 de Ayşe ile Live",
                                20,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            ),
                            UsersResponseItem(
                                "Empty Data View",
                                "Bugün 21:00 de Ayşe ile Live",
                                30,
                                "https://i.hizliresim.com/s4p0zb1.png"
                            ),
                            UsersResponseItem(
                                "Empty Data View",
                                "Bugün 21:00 de Ayşe ile Live",
                                40,
                                "https://i.hizliresim.com/tlq6r9z.png"
                            )
                        )
                    )
                    // Add more sample data as needed
                )

                BohoClubSceen(sampleData)
            }
        }
    }
}/*
{   "socketData": [
     {
           "type": "YouFollow",
                  "position": 1,
                         "listItem":
                         [
                          {
                               "title": "👤 Users You Follow",
                                        "userName": "Serdar Test 1",
                                                  "userImage": "https://i.hizliresim.com/s4p0zb1.png",
                                "userId": 50
                                    },
              {
  "title": "👤 Users You Follow",
                                                                                    "userName": "Serdar Test 2",
                                                                                              "userImage": "https://i.hizliresim.com/tlq6r9z.png",
                                                                                                      "userId": 50
                                                                                                         },
                                                                                                               {
                                                                                                                       "title": "👤 Users You Follow",
                                                                                                                             "userName": "Serdar Test 3",
                                                                                                                                 "userImage": "https://i.hizliresim.com/s4p0zb1.png",
                                                                                                                                         "userId": 50         },         {           "title": "👤 Users You Follow",           "userName": "Serdar Test 4",           "userImage": "https://i.hizliresim.com/tlq6r9z.png",           "userId": 50         }       ]     },     {       "type": "VideoMatches",       "position": 0,       "listItem": [         {           "title": "📸 Best Video Matches",           "userName": "Serdar Test 1",           "userImage": "https://i.hizliresim.com/s4p0zb1.png",           "userId": 40         },         {           "title": "📸 Best Video Matches",           "userName": "Serdar Test 2",           "userImage": "https://i.hizliresim.com/tlq6r9z.png",           "userId": 40         },         {           "title": "📸 Best Video Matches",           "userName": "Serdar Test 3",           "userImage": "https://i.hizliresim.com/s4p0zb1.png",           "userId": 40         },         {           "title": "📸 Best Video Matches",           "userName": "Serdar Test 4",           "userImage": "https://i.hizliresim.com/tlq6r9z.png",           "userId": 40         }       ]     },     {       "type": "MostPopular",       "position": 3,       "listItem": [         {           "title": "🤍 Most Popular",           "userName": "Serdar Test 1",           "userImage": "https://i.hizliresim.com/s4p0zb1.png",           "userId": 20         },         {           "title": "🤍 Most Popular",           "userName": "Serdar Test 2",           "userImage": "https://i.hizliresim.com/tlq6r9z.png",           "userId": 20         },         {           "title": "🤍 Most Popular",           "userName": "Serdar Test 3",           "userImage": "https://i.hizliresim.com/s4p0zb1.png",           "userId": 20         },         {           "title": "🤍 Most Popular",           "userName": "Serdar Test 4",           "userImage": "https://i.hizliresim.com/tlq6r9z.png",           "userId": 20         }       ]     },     {       "type": "Empty",       "position": 4,       "listItem": [         {           "title": "Empty Data View",           "userName": "Serdar",           "userImage": "https://i.hizliresim.com/s4p0zb1.png",           "userId": 10         }       ]     }   ] }
*/
