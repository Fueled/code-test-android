package com.fueled.technicalchallenge.presentation.character_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.fueled.technicalchallenge.data.model.CharacterApiModel

@Composable
internal fun CharacterCard(
    modifier: Modifier = Modifier,
    data: CharacterApiModel,
) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(fraction = 0.5F)
            .aspectRatio(1F, false),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.BottomStart,
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberAsyncImagePainter(data.defaultImageUrl),
                contentDescription = "Character Image",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 8.dp))
                    .background(MaterialTheme.colorScheme.primary),
            ) {
                Text(
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimary),
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp,
                    ),
                    text = data.name,
                    maxLines = 1,
                )
            }
        }
    }
}