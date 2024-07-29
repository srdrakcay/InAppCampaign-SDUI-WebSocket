package com.talkie.inappcampaign_sdui_websocket.data.repository

import com.talkie.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import kotlinx.coroutines.flow.Flow

interface SocketNetworkRepository {
    fun getSocketEventData() : Flow<WebSocketResource>

}