package dev.ionice.playground.images.unsplash

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.ionice.playground.BuildConfig
import dev.ionice.playground.images.unsplash.objects.UnsplashSearchResults
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.unsplash.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface UnsplashApiService {
    @GET("search/photos?client_id=${BuildConfig.uska}")
    suspend fun searchImages(@Query("query") searchTerm: String): UnsplashSearchResults

    @GET("photos/{id}/download")
    suspend fun downloadImage(@Path("id") photoId: String)

    @GET("photos/{id}")
    suspend fun getImage(@Path("id") photoId: String)
}

object UnsplashApi {
    val service: UnsplashApiService by lazy { retrofit.create(UnsplashApiService::class.java) }
}