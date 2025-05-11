package com.mertyigit0.netwatcher.data.di

import android.app.Application
import androidx.room.Room
import com.mertyigit0.netwatcher.data.local.AppDatabase
import com.mertyigit0.netwatcher.data.local.dao.ConnectionDao
import com.mertyigit0.netwatcher.data.repository.ConnectionRepositoryImpl
import com.mertyigit0.netwatcher.domain.repository.ConnectionRepository
import com.mertyigit0.netwatcher.domain.usecase.connection.ConnectionUseCases
import com.mertyigit0.netwatcher.domain.usecase.connection.GetAllConnectionEventsUseCase
import com.mertyigit0.netwatcher.domain.usecase.connection.GetLastConnectionEventUseCase
import com.mertyigit0.netwatcher.domain.usecase.connection.InsertConnectionEventUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "net_watcher_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideConnectionDao(db: AppDatabase): ConnectionDao {
        return db.connectionDao()
    }

    @Provides
    @Singleton
    fun provideConnectionRepository(dao: ConnectionDao): ConnectionRepository {
        return ConnectionRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideConnectionUseCases(repository: ConnectionRepository): ConnectionUseCases {
        return ConnectionUseCases(
            insertConnectionEvent = InsertConnectionEventUseCase(repository),
            getAllConnectionEvents = GetAllConnectionEventsUseCase(repository),
            getLastConnectionEvent = GetLastConnectionEventUseCase(repository)
        )
    }
}