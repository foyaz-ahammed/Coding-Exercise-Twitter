package com.twitter.challenge.repository.api

import com.twitter.challenge.repository.entities.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("current.json")
    suspend fun getCurrentWeather(): Response.WeatherData

    @GET("future_{id}.json")
    suspend fun getFutureWeather(
        @Path("id") id: Int
    ): Response.WeatherData
}