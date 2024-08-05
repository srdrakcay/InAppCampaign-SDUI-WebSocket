package com.serdar.inappcampaign_sdui_websocket.data.di

import com.google.gson.Gson
import com.serdar.inappcampaign_sdui_websocket.data.di.Constant.SOCKET_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SocketNetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideWebSocketRequest(): Request {
        return Request.Builder().url(SOCKET_URL).build()
    }

}
object Constant {
    const val SOCKET_URL = "wss://free.blr2.piesocket.com/v3/1?api_key=FtfXQRNNCDFsFPFJSiimRmcc8mB6YZA2vGFoP0l6&notify_self=1"
}