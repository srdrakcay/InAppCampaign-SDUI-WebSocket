package com.talkie.inappcampaign_sdui_websocket.data.websocket

import android.util.Log
import com.google.gson.Gson
import com.talkie.inappcampaign_sdui_websocket.data.dto.SocketResponse
import com.talkie.inappcampaign_sdui_websocket.data.resource.WebSocketResource
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import javax.inject.Inject

class SocketManager @Inject constructor(
    private val gson: Gson,
    private val okhttpClient: OkHttpClient,
    private val webSocketRequest: Request,
) {
    lateinit var socket: WebSocket
    val events: Flow<WebSocketResource> = callbackFlow {
        trySendBlocking(WebSocketResource.Connecting)
        val listener = websocketListener()
        socket = okhttpClient.newWebSocket(webSocketRequest, listener)
        awaitClose {
            socket.cancel()
        }
    }

    private fun ProducerScope<WebSocketResource>.websocketListener(): WebSocketListener {
        return object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                trySendBlocking(WebSocketResource.Connected)
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                val response = gson.fromJson(text, SocketResponse::class.java)
                trySendBlocking(
                    WebSocketResource.Open(
                        response
                    )
                )
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                super.onMessage(webSocket, bytes)
                onMessage(webSocket, String(bytes.toByteArray()))
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                trySendBlocking(WebSocketResource.Closing)
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosed(webSocket, code, reason)
                trySendBlocking(WebSocketResource.Closed)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                trySendBlocking(WebSocketResource.Failure(t.message.toString()))
            }
        }
    }
}