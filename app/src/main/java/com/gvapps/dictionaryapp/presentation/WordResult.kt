package com.gvapps.dictionaryapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gvapps.dictionaryapp.R
import com.gvapps.dictionaryapp.domain.model.Meaning
import com.gvapps.dictionaryapp.domain.model.WordItem

@Composable
fun WordResult(
	wordItem: WordItem
) {
	LazyColumn(
		contentPadding = PaddingValues(vertical = 32.dp)
	) {
		items(wordItem.meanings.size) { index ->
			meaningItem(
				meaning = wordItem.meanings[index],
				index = index
			)
		}
	}
}

@Composable
fun meaningItem(
	meaning: Meaning,
	index: Int
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(16.dp)
	) {
		Text(
			text = "${index + 1}. ${meaning.partOfSpeech}",
			fontSize = 17.sp,
			color = MaterialTheme.colorScheme.onPrimary,
			modifier = Modifier
				.fillMaxWidth()
				.clip(RoundedCornerShape(20.dp))
				.background(
					brush = Brush.horizontalGradient(
						listOf(
							MaterialTheme.colorScheme.primary,
							MaterialTheme.colorScheme.primary.copy(0.4f),
							Color.Transparent
						)
					)
				)
				.padding(
					top = 2.dp, bottom = 4.dp,
					start = 12.dp, end = 12.dp
				)
		)
		if (meaning.definitions.definition.isNotEmpty()) {
			Spacer(modifier = Modifier.height(8.dp))
			Row(
				modifier = Modifier.padding(8.dp)
			) {
				Text(
					text = stringResource(R.string.definition),
					fontWeight = FontWeight.SemiBold,
					fontSize = 19.sp,
					color = MaterialTheme.colorScheme.primary
				)
				Spacer(modifier = Modifier.width(19.dp))
				Text(
					text = meaning.definitions.definition,
					fontSize = 17.sp,
					color = MaterialTheme.colorScheme.onBackground
				)
			}
		}
		if (meaning.definitions.example.isNotEmpty()) {
			Spacer(modifier = Modifier.height(8.dp))
			Row(
				modifier = Modifier.padding(8.dp)
			) {
				Text(
					text = stringResource(R.string.example),
					fontWeight = FontWeight.SemiBold,
					fontSize = 19.sp,
					color = MaterialTheme.colorScheme.primary
				)
				Spacer(modifier = Modifier.width(19.dp))
				Text(
					text = meaning.definitions.example,
					fontSize = 17.sp,
					color = MaterialTheme.colorScheme.onBackground
				)
			}
		}
	}
}