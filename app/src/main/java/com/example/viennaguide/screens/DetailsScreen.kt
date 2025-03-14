package com.example.viennaguide.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.viennaguide.repository.PlacesRepository
import androidx.compose.material.icons.filled.ArrowBack




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(placeId: Int, navController: NavController) {
    val place = PlacesRepository.getPlaceById(placeId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(place?.name ?: "Не найдено") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")

                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            place?.let {
                Image(
                    painter = painterResource(id = it.imageRes),
                    contentDescription = it.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(2.dp, Color.Gray, RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = it.name, style = MaterialTheme.typography.titleLarge)
                Text(text = "Рейтинг: ${it.rating}", style = MaterialTheme.typography.bodyMedium)
                Text(text = it.description, style = MaterialTheme.typography.bodyMedium)
            } ?: Text("Место не найдено", modifier = Modifier.padding(16.dp))
        }
    }
}



