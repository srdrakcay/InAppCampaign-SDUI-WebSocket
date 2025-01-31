package com.serdar.inappcampaign_sdui_websocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.data.dto.UsersResponseItem
import com.serdar.inappcampaign_sdui_websocket.feature.bohoclub.BohoClubEventContent
import com.serdar.inappcampaign_sdui_websocket.feature.bohoclub.BohoClubSceen
import com.serdar.inappcampaign_sdui_websocket.feature.bohopaywall.SDUIScreen
import com.serdar.inappcampaign_sdui_websocket.feature.bohopaywall.ScreenConfig
import com.serdar.inappcampaign_sdui_websocket.feature.onetoone.OneToOneScreen
import com.serdar.inappcampaign_sdui_websocket.ui.theme.InAppCampaignSDUIWebSocketTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.json.Json

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InAppCampaignSDUIWebSocketTheme {
                SDUIScreenPreview()
            }
        }
    }
}
@Composable
fun SDUIScreenPreview() {
    val jsonString = """
{
  "type": "screen",
  "background": "#FFFFFF",
  "padding": 16,
  "children": [
    {
      "type": "text",
      "content": "Welcome to Boho Paywall",
      "style": {
        "color": "#000000",
        "fontSize": 20,
        "fontWeight": "bold",
        "paddingBottom": 8
      }
    },
    {
      "type": "grid",
      "columns": 1,
      "items": [
        {
          "data": {
            "amount": 10,
            "period": "month",
            "discount": 20,
            "originalPrice": "${'$'}12.99",
            "price": "${'$'}9.99",
            "tag": "Best Deal"
          },
          "style": {
            "selectedBorderColor": "#FF9800",
            "unselectedBorderColor": "#E0E0E0",
            "backgroundColor": "#FFFFFF",
            "tagBackgroundColor": "#FFC107"
          }
        },
         {
          "data": {
            "amount": 10,
            "period": "month",
            "discount": 20,
            "originalPrice": "${'$'}12.99",
            "price": "${'$'}9.99",
            "tag": "Best Deal"
          },
          "style": {
            "selectedBorderColor": "#FF9800",
            "unselectedBorderColor": "#E0E0E0",
            "backgroundColor": "#FFFFFF",
            "tagBackgroundColor": "#FFC107"
          }
        },
         {
          "data": {
            "amount": 10,
            "period": "month",
            "discount": 20,
            "originalPrice": "${'$'}12.99",
            "price": "${'$'}9.99",
            "tag": "Best Deal"
          },
          "style": {
            "selectedBorderColor": "#FF9800",
            "unselectedBorderColor": "#E0E0E0",
            "backgroundColor": "#FFFFFF",
            "tagBackgroundColor": "#FFC107"
          }
        }
      ]
    },
    {
      "type": "featuresList",
      "items": [
        "Unlimited access",
        "Ad-free experience",
        "Priority support"
      ],
      "style": {
        "bulletColor": "#FF5722",
        "textColor": "#333333",
        "spacing": 8
      }
    },
    {
      "type": "button",
      "content": "Subscribe Now",
      "style": {
        "gradient": {
          "startColor": "#FF9800",
          "endColor": "#F44336"
        },
        "height": 48,
        "cornerRadius": 8
      }
    },
    {
      "type": "lists",
      "types": "HORIZONTAL",
      "items": [
        {
          "type": "listItem",
          "data": {
            "title": "Premium Plan",
            "subtitle": "Best for professionals",
            "image": "https://example.com/image.png",
            "badge": "Popular",
            "price": "${'$'}9.99/month",
            "description": "Access to exclusive content"
          },
          "style": {
            "backgroundColor": "#FAFAFA",
            "cornerRadius": 12,
            "elevation": 4,
            "titleColor": "#000000",
            "subtitleColor": "#757575",
            "padding": {
              "horizontal": 16,
              "vertical": 12
            }
          }
        },
         {
          "type": "listItem",
          "data": {
            "title": "Premium Plan",
            "subtitle": "Best for professionals",
            "image": "https://example.com/image.png",
            "badge": "Popular",
            "price": "${'$'}9.99/month",
            "description": "Access to exclusive content"
          },
          "style": {
            "backgroundColor": "#FAFAFA",
            "cornerRadius": 12,
            "elevation": 4,
            "titleColor": "#000000",
            "subtitleColor": "#757575",
            "padding": {
              "horizontal": 16,
              "vertical": 12
            }
          }
        },
         {
          "type": "listItem",
          "data": {
            "title": "Premium Plan",
            "subtitle": "Best for professionals",
            "image": "https://example.com/image.png",
            "badge": "Popular",
            "price": "${'$'}9.99/month",
            "description": "Access to exclusive content"
          },
          "style": {
            "backgroundColor": "#FAFAFA",
            "cornerRadius": 12,
            "elevation": 4,
            "titleColor": "#000000",
            "subtitleColor": "#757575",
            "padding": {
              "horizontal": 16,
              "vertical": 12
            }
          }
        }
      ],
      "style": {
        "spacing": 16,
        "padding": {
          "horizontal": 16,
          "vertical": 12
        },
        "cardStyle": "OUTLINED"
      }
    },
    {
      "type": "reviewCard",
      "data": {
        "title": "Great Service!",
        "rating": 5,
        "review": "I've been using this for months, and it's amazing.",
        "author": "John Doe",
        "date": "2024-01-31"
      },
      "style": {
        "backgroundColor": "#FFFFFF",
        "textColor": "#000000",
        "secondaryTextColor": "#757575"
      }
    }
  ]
}

    """.trimIndent()
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    val screenConfig = json.decodeFromString<ScreenConfig>(jsonString)
    SDUIScreen(screenConfig)
}





/*
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
