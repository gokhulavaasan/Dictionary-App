package com.example.news.data.mapper

import com.gvapps.dictionaryapp.data.dto.DefinitionDto
import com.gvapps.dictionaryapp.data.dto.MeaningDto
import com.gvapps.dictionaryapp.data.dto.WordItemDto
import com.gvapps.dictionaryapp.domain.model.Definition
import com.gvapps.dictionaryapp.domain.model.Meaning
import com.gvapps.dictionaryapp.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem(
	word = word ?: "",
	meanings = meanings?.map {
		it.toMeaning()
	} ?: emptyList(),
	phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
	definitions = definitionDtoToDefinition(definitions?.get(0)),
	partOfSpeech = partOfSpeech ?: ""
)


fun definitionDtoToDefinition(
	definitionDto: DefinitionDto?
) = Definition(
	definition = definitionDto?.definition ?: "",
	example = definitionDto?.example ?: ""
)