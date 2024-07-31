package com.serdar.inappcampaign_sdui_websocket.data.repository

import com.serdar.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import com.serdar.inappcampaign_sdui_websocket.data.websocket.SocketManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SocketNetworkRepositoryImpl @Inject constructor( private val socketService: SocketManager) :SocketNetworkRepository{
    override fun getSocketEventData(): Flow<WebSocketResource> {
        return socketService.events
    }

}