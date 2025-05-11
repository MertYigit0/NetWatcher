package com.mertyigit0.netwatcher.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mertyigit0.netwatcher.data.local.dao.ConnectionDao
import com.mertyigit0.netwatcher.data.local.entity.ConnectionEventEntity

@Database(entities = [ConnectionEventEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)  // LocalDateTime için converter
abstract class AppDatabase : RoomDatabase() {

    abstract fun connectionDao(): ConnectionDao
}