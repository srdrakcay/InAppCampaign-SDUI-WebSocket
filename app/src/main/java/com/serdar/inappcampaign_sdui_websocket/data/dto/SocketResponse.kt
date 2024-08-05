package com.serdar.inappcampaign_sdui_websocket.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class SocketResponse (
  val  socketData:List<SocketResponseItem>
)