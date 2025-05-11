package com.mertyigit0.netwatcher.domain.repository

import com.mertyigit0.netwatcher.domain.model.ConnectionEvent
import kotlinx.coroutines.flow.Flow

interface ConnectionRepository {

    suspend fun insertConnectionEvent(event: ConnectionEvent)

    fun getAllConnectionEvents(): Flow<List<ConnectionEvent>>

    fun getLastConnectionEvent(): Flow<ConnectionEvent?>
}