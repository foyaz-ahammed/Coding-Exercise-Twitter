package com.twitter.challenge.repository.entities

class WeatherInfo(val temperature: Float, val windSpeed: Float, private val cloudiness: Int) {
    companion object {
        const val CLOUDINESS_LIMIT = 50
    }

    constructor(weatherData: Response.WeatherData): this(weatherData.weather.temp, weatherData.wind.speed, weatherData.clouds.cloudiness)

    fun showCloudIcon() = cloudiness > CLOUDINESS_LIMIT
}