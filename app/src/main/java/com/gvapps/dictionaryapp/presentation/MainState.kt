package com.gvapps.dictionaryapp.presentation

import com.gvapps.dictionaryapp.domain.model.WordItem

data class MainState(
	val isLoading: Boolean = false,
	val searchWord: String = "",
	val wordItem: WordItem? = null
)
