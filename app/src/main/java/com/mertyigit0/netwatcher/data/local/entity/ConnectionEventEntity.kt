package com.mertyigit0.netwatcher.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "connection_events")
data class ConnectionEventEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val isConnected: Boolean,
    val timestamp: LocalDateTime
)