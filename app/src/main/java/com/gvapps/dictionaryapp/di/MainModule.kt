package com.gvapps.dictionaryapp.di

import com.gvapps.dictionaryapp.data.api.DictionaryApi
import com.gvapps.dictionaryapp.data.api.DictionaryApi.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton
import kotlin.apply


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

	private val interceptor: HttpLoggingInterceptor =
		HttpLoggingInterceptor().apply {
			level = HttpLoggingInterceptor.Level.BODY
		}
	private val client: OkHttpClient = OkHttpClient.Builder()
		.addInterceptor(interceptor)
		.build()

	@Provides
	@Singleton
	fun ProvidesDictionaryApi(): DictionaryApi {
		return Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.client(client)
			.build()
			.create()
	}

}

