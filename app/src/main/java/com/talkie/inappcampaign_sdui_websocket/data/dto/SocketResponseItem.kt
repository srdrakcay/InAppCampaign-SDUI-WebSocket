package com.talkie.inappcampaign_sdui_websocket.data.dto


import kotlinx.serialization.SerialName

data class SocketResponseItem(
    @SerialName("alignment") val alignment: String,
    @SerialName("alignmentButton") val alignmentButton: String,
    @SerialName("alignmentText") val alignmentText: String,
    @SerialName("cardElevation") val cardElevation: Int,
    @SerialName("height") val height: Int,
    @SerialName("imageSize") val imageSize: Int,
    @SerialName("messageText") val messageText: String,
    @SerialName("paddingButton") val paddingButton: Int,
    @SerialName("paddingCard") val paddingCard: Int,
    @SerialName("paddingText") val paddingText: Int,
    @SerialName("painterResource") val painterResource: String,
    @SerialName("roundedCornerShape") val roundedCornerShape: Int,
    @SerialName("texSize") val texSize: Int,
    @SerialName("type") val type: String,
    @SerialName("verticalGradient1") val verticalGradient1: String,
    @SerialName("verticalGradient2") val verticalGradient2: String,
    @SerialName("cardTimeCornerRadius") val cardTimeCornerRadius: Int,
    @SerialName("sizeW") val sizeW: Int,
    @SerialName("sizeH") val sizeH: Int,
    @SerialName("cardPadding") val cardPadding: Int,
    @SerialName("cardTimeElevation") val cardTimeElevation: Int,


    )