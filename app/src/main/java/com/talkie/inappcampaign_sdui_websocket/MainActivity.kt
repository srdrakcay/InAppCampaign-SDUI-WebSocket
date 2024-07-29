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
