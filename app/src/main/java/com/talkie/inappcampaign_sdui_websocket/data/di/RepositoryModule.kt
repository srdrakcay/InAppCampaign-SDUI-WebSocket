package com.talkie.inappcampaign_sdui_websocket.data.di

import com.talkie.inappcampaign_sdui_websocket.data.repository.SocketNetworkRepository
import com.talkie.inappcampaign_sdui_websocket.data.repository.SocketNetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun binds(impl : SocketNetworkRepositoryImpl) : SocketNetworkRepository
}