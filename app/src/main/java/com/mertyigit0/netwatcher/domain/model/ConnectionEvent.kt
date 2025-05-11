package com.mertyigit0.netwatcher.domain.model

import java.time.LocalDateTime

data class ConnectionEvent(
    val isConnected: Boolean,
    val timestamp: LocalDateTime
)