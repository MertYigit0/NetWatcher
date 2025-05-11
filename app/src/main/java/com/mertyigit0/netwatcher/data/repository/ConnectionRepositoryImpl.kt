package com.mertyigit0.netwatcher.data.repository

import com.mertyigit0.netwatcher.data.local.dao.ConnectionDao
import com.mertyigit0.netwatcher.data.local.entity.ConnectionEventEntity
import com.mertyigit0.netwatcher.domain.model.ConnectionEvent
import com.mertyigit0.netwatcher.domain.repository.ConnectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map




class ConnectionRepositoryImpl(
    private val dao: ConnectionDao
) : ConnectionRepository {

    override suspend fun insertConnectionEvent(event: ConnectionEvent) {
        dao.insert(event.toEntity())
    }

    override fun getAllConnectionEvents(): Flow<List<ConnectionEvent>> {
        return dao.getAll().map { list -> list.map { it.toDomain() } }
    }

    override fun getLastConnectionEvent(): Flow<ConnectionEvent?> {
        return dao.getLast().map { it?.toDomain() }
    }
}


fun ConnectionEvent.toEntity(): ConnectionEventEntity {
    return ConnectionEventEntity(
        isConnected = isConnected,
        timestamp = timestamp
    )
}

// Entity -> Domain
fun ConnectionEventEntity.toDomain(): ConnectionEvent {
    return ConnectionEvent(
        isConnected = isConnected,
        timestamp = timestamp
    )
}