package com.serdar.inappcampaign_sdui_websocket.feature

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serdar.inappcampaign_sdui_websocket.data.dto.SocketResponseItem
import com.serdar.inappcampaign_sdui_websocket.data.repository.SocketNetworkRepository
import com.serdar.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: SocketNetworkRepository) :
    ViewModel() {

    private val _socketData = mutableStateListOf<SocketResponseItem>()
    val socketData: List<SocketResponseItem> get() = _socketData

    init {
        connectSocket()
    }

    private fun connectSocket() {
        viewModelScope.launch {
            repository.getSocketEventData().distinctUntilChanged().collect {
                when (it) {
                    WebSocketResource.Closed -> {

                    }

                    WebSocketResource.Closing -> {

                    }

                    WebSocketResource.Connected -> {

                    }

                    WebSocketResource.Connecting -> {

                    }

                    is WebSocketResource.Failure -> {

                    }

                    is WebSocketResource.Open -> {
                        val data = it.response.socketData.sortedBy { it.position }
                        _socketData.clear()
                        _socketData.addAll(data)
                    }

                }

            }

        }
    }

}