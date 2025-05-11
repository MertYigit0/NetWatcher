package com.mertyigit0.netwatcher.presentation.connection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertyigit0.netwatcher.domain.model.ConnectionEvent
import com.mertyigit0.netwatcher.domain.usecase.connection.ConnectionUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ConnectionState {
    object Loading : ConnectionState()
    data class Success(val events: List<ConnectionEvent>) : ConnectionState()
    data class Error(val message: String) : ConnectionState()
}

@HiltViewModel
class ConnectionViewModel @Inject constructor(
    private val connectionUseCases: ConnectionUseCases
) : ViewModel() {

    private val _connectionState = MutableStateFlow<ConnectionState>(ConnectionState.Loading)
    val connectionState: StateFlow<ConnectionState> = _connectionState

    init {
        getAllConnectionEvents()
    }

    private fun getAllConnectionEvents() {
        viewModelScope.launch {
            connectionUseCases.getAllConnectionEvents().collect { events ->
                if (events.isEmpty()) {
                    _connectionState.value = ConnectionState.Error("No connection events found.")
                } else {
                    _connectionState.value = ConnectionState.Success(events)
                }
            }
        }
    }

    fun addConnectionEvent(event: ConnectionEvent) {
        viewModelScope.launch {
            connectionUseCases.insertConnectionEvent(event)
            getAllConnectionEvents()  // refresh events after adding
        }
    }
}