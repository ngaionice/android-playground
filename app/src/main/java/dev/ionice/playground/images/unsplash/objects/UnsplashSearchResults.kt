package dev.ionice.playground.images.unsplash.objects

import com.squareup.moshi.Json

data class UnsplashSearchResults(
    val total: Int,
    @Json(name = "total_pages") val totalPages: Int,
    val results: List<UnsplashPhoto>
)
