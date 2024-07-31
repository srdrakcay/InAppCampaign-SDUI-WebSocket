package com.serdar.inappcampaign_sdui_websocket.feature

enum class ViewScreenType {
    Text,
    Image;
    companion object {
        fun fromString(type: String): ViewScreenType? {
            return when (type.uppercase()) {
                "TEXT" -> Text
                "IMAGE" -> Image
                else -> {Text}
            }
        }
    }
}
