package com.serdar.inappcampaign_sdui_websocket.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UsersResponseItem(
    val title:String,
    val userName:String,
    val userId:Int,
    val userImage:String,
)