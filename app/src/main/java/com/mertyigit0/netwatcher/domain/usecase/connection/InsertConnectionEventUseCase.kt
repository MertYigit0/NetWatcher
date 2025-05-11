package com.mertyigit0.netwatcher.domain.usecase.connection

import com.mertyigit0.netwatcher.domain.model.ConnectionEvent
import com.mertyigit0.netwatcher.domain.repository.ConnectionRepository

class InsertConnectionEventUseCase(
    private val repository: ConnectionRepository
) {
    suspend operator fun invoke(event: ConnectionEvent) {
        repository.insertConnectionEvent(event)
    }
}