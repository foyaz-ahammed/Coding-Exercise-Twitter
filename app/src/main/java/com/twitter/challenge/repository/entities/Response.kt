package com.twitter.challenge.repository.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Network response classes
 */
class Response {
    @JsonClass(generateAdapter = true)
    class WeatherData(
        @Json(name = "weather") val weather: Weather,
        @Json(name = "wind") val wind: Wind,
        @Json(name = "clouds") val clouds: Clouds
    )

    @JsonClass(generateAdapter = true)
    class Weather(
        @Json(name = "temp") val temp: Float
    )

    @JsonClass(generateAdapter = true)
    class Wind(
        @Json(name = "speed") val speed: Float
    )

    @JsonClass(generateAdapter = true)
    class Clouds(
        @Json(name = "cloudiness") val cloudiness: Int
    )
}