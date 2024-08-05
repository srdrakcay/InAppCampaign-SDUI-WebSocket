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
                        Log.e("TAG", "connectSocket Closed: ${it} ", )

                    }

                    WebSocketResource.Closing -> {
                        Log.e("TAG", "connectSocket Closing: ${it} ", )

                    }

                    WebSocketResource.Connected -> {
                        Log.e("TAG", "connectSocket Connected: ${it} ", )

                    }

                    WebSocketResource.Connecting -> {
                        Log.e("TAG", "connectSocket Connecting: ${it} ", )

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