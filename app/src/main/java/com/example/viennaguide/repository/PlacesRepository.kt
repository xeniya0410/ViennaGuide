package com.example.viennaguide.repository

import android.util.Log
import com.example.viennaguide.R
import com.example.viennaguide.model.Place

object PlacesRepository {
    private val places = listOf(
        Place(1, "Шёнбрунн", "Достопримечательности", "Дворец Шёнбрунн - одна из главных достопримечательностей Вены.", 4.8f, R.drawable.schonbrunn),
        Place(2, "Пратер", "Парки", "Пратер - знаменитый парк с аттракционами, включая колесо обозрения.", 4.7f, R.drawable.vienna_prater),
        Place(3, "Фигльмюллер", "Рестораны", "Фигльмюллер - знаменитый ресторан, известный своим шницелем.", 4.6f, R.drawable.figlmuller)
    )

    fun getPlacesByCategory(category: String): List<Place> {
        Log.d("PlacesRepository", "Запрошенная категория: $category") // ✅ Логируем категорию
        Log.d("PlacesRepository", "Все доступные места: $places") // ✅ Логируем весь список

        val filteredPlaces = places.filter { it.category == category }

        Log.d("PlacesRepository", "Отфильтрованные места: $filteredPlaces") // ✅ Логируем результат

        return filteredPlaces
    }

    fun getPlaceById(id: Int): Place? {
        return places.find { it.id == id }
    }
}
