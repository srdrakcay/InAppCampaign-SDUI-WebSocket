package com.talkie.inappcampaign_sdui_websocket.feature

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.talkie.inappcampaign_sdui_websocket.data.dto.SocketResponse
import com.talkie.inappcampaign_sdui_websocket.data.repository.SocketNetworkRepository
import com.talkie.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: SocketNetworkRepository) :
    ViewModel() {

    private val _socketData = mutableStateListOf<SocketResponse>()
    val socketData: List<SocketResponse> get() = _socketData
        init {
            connectSocket()
        }

    private fun connectSocket() {
        viewModelScope.launch {
            repository.getSocketEventData().distinctUntilChanged().collect{
                when(it){
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
                            _socketData.clear()
                            _socketData.add(it.response)
                        }

                }

            }

        }
    }


}