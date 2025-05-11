package com.mertyigit0.netwatcher.data.local.dao

import androidx.room.*
import com.mertyigit0.netwatcher.data.local.entity.ConnectionEventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConnectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(event: ConnectionEventEntity)

    @Query("SELECT * FROM connection_events ORDER BY timestamp DESC")
    fun getAll(): Flow<List<ConnectionEventEntity>>

    @Query("SELECT * FROM connection_events ORDER BY timestamp DESC LIMIT 1")
    fun getLast(): Flow<ConnectionEventEntity?>
}