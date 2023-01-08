package dev.ionice.playground.geolocation

import dev.ionice.playground.geolocation.geoapify.GeoapifyApi

suspend fun getCityName(coordinates: Coordinates): String {
    val apiService = GeoapifyApi.service
    val results = apiService.reverseGeocode(coordinates.lat, coordinates.lon).features[0].properties
    return "${results.city}, ${results.state}, ${results.country}"
}