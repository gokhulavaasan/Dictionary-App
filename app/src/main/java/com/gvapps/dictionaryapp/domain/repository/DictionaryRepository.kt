package com.gvapps.dictionaryapp.domain.repository

import com.gvapps.dictionaryapp.domain.model.WordItem
import com.gvapps.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
	suspend fun getWordResult(
		word: String
	): Flow<Result<WordItem>>
}