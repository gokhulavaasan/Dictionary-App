package com.gvapps.dictionaryapp.di

import com.gvapps.dictionaryapp.data.repository.DictionaryRepositoryImpl
import com.gvapps.dictionaryapp.domain.repository.DictionaryRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
	abstract fun bindDictionaryRepository(
		dictionaryRepositoryImpl: DictionaryRepositoryImpl
	): DictionaryRepository
}