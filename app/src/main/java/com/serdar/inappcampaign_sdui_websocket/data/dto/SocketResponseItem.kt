package com.serdar.inappcampaign_sdui_websocket.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class SocketResponseItem(
    @SerialName("type") val type: String,
    @SerialName("position") val position : Int,
    @SerialName("listItem") val listItem :List<UsersResponseItem>
    )