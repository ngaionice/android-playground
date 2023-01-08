package dev.ionice.playground.geolocation.geoapify.objects

import com.squareup.moshi.Json

data class ReverseGeocodeResult(val features: List<ReverseGeocodeResultFeature>)

data class ReverseGeocodeResultFeature(val properties: ReverseGeocodeResultFeatureProperties)

data class ReverseGeocodeResultFeatureProperties(val city: String, @Json(name ="state_code") val state: String, val country: String)