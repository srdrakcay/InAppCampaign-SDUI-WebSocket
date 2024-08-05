package com.serdar.inappcampaign_sdui_websocket.util

import androidx.compose.ui.graphics.Color
import com.serdar.inappcampaign_sdui_websocket.ui.theme.BlueFirst
import com.serdar.inappcampaign_sdui_websocket.ui.theme.PinkFirst

fun colorText(color: String): Color {
    return when (color) {
        "Blue" -> {
            Color.Blue
        }

        "Red" -> {
            Color.Red
        }

        "Green" -> {
            Color.Green
        }

        "Yellow" -> {
            Color.Yellow
        }
        "PinkFirst" -> {
            PinkFirst
        }
        "BlueFirst" -> {
            BlueFirst
        }

        else -> {
            Color.Black
        }
    }
}