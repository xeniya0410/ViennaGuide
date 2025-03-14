package com.example.viennaguide.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.viennaguide.viewmodel.PlacesViewModel
import com.example.viennaguide.model.Place
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesScreen(category: String, navController: NavController) {
    val viewModel: PlacesViewModel = viewModel()
    val places by viewModel.places.collectAsState()

    LaunchedEffect(category) {
        viewModel.loadPlaces(category)
    }

    Log.d("PlacesScreen", "Полученные места: $places")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(category) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(places) { place ->
                PlaceItem(place) { navController.navigate("details/${place.id}") }
            }
        }
    }
}

@Composable
fun PlaceItem(place: Place, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = place.name, style = MaterialTheme.typography.titleLarge)
            Text(text = place.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
