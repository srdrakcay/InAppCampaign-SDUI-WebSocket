package com.talkie.inappcampaign_sdui_websocket.data.repository

import com.talkie.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import com.talkie.inappcampaign_sdui_websocket.data.websocket.SocketManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SocketNetworkRepositoryImpl @Inject constructor( private val socketService: SocketManager) :SocketNetworkRepository{
    override fun getSocketEventData(): Flow<WebSocketResource> {
        return socketService.events
    }

}