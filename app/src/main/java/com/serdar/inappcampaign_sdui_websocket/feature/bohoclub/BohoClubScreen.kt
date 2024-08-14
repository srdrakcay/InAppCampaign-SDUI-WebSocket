package com.serdar.inappcampaign_sdui_websocket.feature.bohoclub

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.feature.MainViewModel
import com.serdar.inappcampaign_sdui_websocket.feature.onetoone.DifferentItemsLazyColumn
import com.serdar.inappcampaign_sdui_websocket.feature.onetoone.TopBarContent

@Composable
fun BohoClubSceen(data: List<SocketResponseItem>, mainViewModel: MainViewModel = hiltViewModel()) {
    Scaffold(modifier = Modifier, containerColor = Color.Black, topBar = {
        TopBarContent()
    }, bottomBar = {

    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            DifferentItemsLazyColumn(
                Modifier
                    .weight(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF000000), Color(0xFFAC03F4), Color(0xFFDD1584)
                            )
                        )
                    ), mainViewModel.socketData, data, onVoiceClick = {
                Log.e("TAG", "OneToOneScreen: onVoiceClick ")
            }, onVideoClick = {
                Log.e("TAG", "OneToOneScreen: onVideoClick ")

            }

            )


        }


    }
}