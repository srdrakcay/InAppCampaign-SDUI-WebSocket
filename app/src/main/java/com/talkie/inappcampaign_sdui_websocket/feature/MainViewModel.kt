package com.talkie.inappcampaign_sdui_websocket.feature

import androidx.lifecycle.ViewModel
import com.talkie.inappcampaign_sdui_websocket.data.repository.SocketNetworkRepository
import com.talkie.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: SocketNetworkRepository) :
    ViewModel() {


    val socketEvent: Flow<WebSocketResource> =
        repository.getSocketEventData().distinctUntilChanged()


}