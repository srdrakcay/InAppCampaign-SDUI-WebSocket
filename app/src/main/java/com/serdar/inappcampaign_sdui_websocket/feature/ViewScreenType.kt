package com.serdar.inappcampaign_sdui_websocket.feature

enum class ViewScreenType {
    Text, Image, YouFollow, VideoMatches, Empty, MostPopular;

    companion object {
        fun fromString(type: String): ViewScreenType {
            return when (type.uppercase()) {
                "Best Video Matches" -> VideoMatches
                "Users You Follow" -> YouFollow
                "Most Popular" -> MostPopular
                else -> {
                    Empty
                }
            }
        }
    }
}
