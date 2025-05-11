package com.mertyigit0.netwatcher.domain.usecase.connection

import com.mertyigit0.netwatcher.domain.model.ConnectionEvent
import com.mertyigit0.netwatcher.domain.repository.ConnectionRepository
import kotlinx.coroutines.flow.Flow

class GetLastConnectionEventUseCase(
    private val repository: ConnectionRepository
) {
    operator fun invoke(): Flow<ConnectionEvent?> {
        return repository.getLastConnectionEvent()
    }
}