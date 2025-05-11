package com.mertyigit0.netwatcher.domain.usecase.connection

data class ConnectionUseCases(
    val insertConnectionEvent: InsertConnectionEventUseCase,
    val getAllConnectionEvents: GetAllConnectionEventsUseCase,
    val getLastConnectionEvent: GetLastConnectionEventUseCase
)