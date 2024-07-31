package com.serdar.inappcampaign_sdui_websocket.data.resource

import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponse

sealed class WebSocketResource {
    data object Connecting : WebSocketResource()
    data object Connected : WebSocketResource()
    data class Open(val response: SocketResponse) : WebSocketResource()
    data object Closed : WebSocketResource()
    data object Closing : WebSocketResource()
    data class Failure(val response: String?) : WebSocketResource()
}