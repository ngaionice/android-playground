package dev.ionice.playground.images.unsplash.objects

data class UnsplashUser(val name: String, val links: UnsplashUserLinks)

data class UnsplashUserLinks(val html: String)