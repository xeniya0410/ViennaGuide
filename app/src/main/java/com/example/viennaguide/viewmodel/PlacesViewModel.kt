package com.example.viennaguide.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viennaguide.model.Place
import com.example.viennaguide.repository.PlacesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.util.Log

class PlacesViewModel : ViewModel() {
    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>> = _places

    fun loadPlaces(category: String) {
        val filteredPlaces = PlacesRepository.getPlacesByCategory(category)
        _places.value = filteredPlaces
        Log.d("PlacesViewModel", "Загруженные места: $filteredPlaces") 
    }
}
