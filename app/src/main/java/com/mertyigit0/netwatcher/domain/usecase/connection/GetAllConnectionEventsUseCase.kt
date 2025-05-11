package com.mertyigit0.netwatcher.domain.usecase.connection

import com.mertyigit0.netwatcher.domain.model.ConnectionEvent
import com.mertyigit0.netwatcher.domain.repository.ConnectionRepository
import kotlinx.coroutines.flow.Flow

class GetAllConnectionEventsUseCase(
    private val repository: ConnectionRepository
) {
    operator fun invoke(): Flow<List<ConnectionEvent>> {
        return repository.getAllConnectionEvents()
    }
}