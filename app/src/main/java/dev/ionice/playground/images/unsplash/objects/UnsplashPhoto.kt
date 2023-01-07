package dev.ionice.playground.images.unsplash.objects

import com.squareup.moshi.Json

data class UnsplashPhoto(
    val id: String,
    val user: UnsplashUser,
    val urls: UnsplashPhotoUrls,
    val links: UnsplashPhotoLinks
)

data class UnsplashPhotoUrls(val regular: String, val small: String)

data class UnsplashPhotoLinks(@Json(name = "download_location") val downloadLocation: String)