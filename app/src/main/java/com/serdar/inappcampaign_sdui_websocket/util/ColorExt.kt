package com.serdar.inappcampaign_sdui_websocket.util

import androidx.compose.ui.graphics.Color

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

        else -> {
            Color.Black
        }
    }
}