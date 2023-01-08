package dev.ionice.playground.geolocation.geoapify

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.ionice.playground.BuildConfig
import dev.ionice.playground.geolocation.geoapify.objects.ReverseGeocodeResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.geoapify.com/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface GeoapifyApiService {
    @GET("geocode/reverse?apiKey=${BuildConfig.gaka}")
    suspend fun reverseGeocode(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("lang") language: String = "en"): ReverseGeocodeResult
}

object GeoapifyApi {
    val service: GeoapifyApiService by lazy { retrofit.create(GeoapifyApiService::class.java) }
}