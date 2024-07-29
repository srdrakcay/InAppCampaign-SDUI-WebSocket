package com.talkie.inappcampaign_sdui_websocket

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.talkie.inappcampaign_sdui_websocket.ui.theme.InAppCampaignSDUIWebSocketTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InAppCampaignSDUIWebSocketTheme {
                    MainScreen()
            }
        }
    }
}
/*
{
  "socketData": [
    {
      "type": "Text",
      "paddingCard": 16,
      "height": 150,
      "roundedCornerShape": 16,
      "cardElevation": 8,
      "verticalGradient1": "Red",
      "verticalGradient2": "Blue",
      "painterResource": "R.drawable.ic_diamond1",
      "alignment": "TopCenter",
      "alignmentText": "BottomCenter",
      "messageText": "Testt",
      "paddingText": 40,
      "imageSize": 120,
      "texSize": 20,
      "alignmentButton": "BottomEnd",
      "cardTimeCornerRadius": 12,
      "sizeW": 120,
      "sizeH": 60,
      "cardPadding": 12,
      "cardTimeElevation": 40
    },
    {
      "type": "Image",
      "paddingCard": 16,
      "height": 150,
      "roundedCornerShape": 16,
      "cardElevation": 8,
      "verticalGradient1": "Green",
      "verticalGradient2": "Yellow",
      "painterResource": "R.drawable.ic_diamond1",
      "alignment": "TopEnd",
      "alignmentText": "TopEnd",
      "messageText": "Sana Özel",
      "paddingText": 40,
      "imageSize": 140,
      "texSize": 20,
      "alignmentButton": "BottomEnd",
      "paddingButton": 40,
      "cardTimeCornerRadius": 12,
      "sizeW": 40,
      "sizeH": 40,
      "cardPadding": 40,
      "cardTimeElevation": 40
    }
  ]
}
*/
