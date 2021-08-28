package com.twitter.challenge.repository

import android.util.Log
import com.twitter.challenge.helpers.NUM_FUTURE_DAYS
import com.twitter.challenge.helpers.TemperatureConverter.Companion.calculateDeviation
import com.twitter.challenge.repository.api.WeatherService
import com.twitter.challenge.repository.entities.DataResult
import com.twitter.challenge.repository.entities.WeatherInfo

class Repository(private val apiService: WeatherService) {
    companion object {
        const val TAG = "Repository"
    }

    suspend fun getCurrentWeather(): DataResult<WeatherInfo> =
        try {
            val weatherData = apiService.getCurrentWeather()
            DataResult.Success(WeatherInfo(weatherData))
        } catch(e: Exception) {
            Log.w(TAG, e.toString())
            DataResult.Failure(e)
        }

    suspend fun getDeviation(): DataResult<Float> =
        try {
            val tempList = ArrayList<Float>()
            for (i in 1 .. NUM_FUTURE_DAYS) {
                val weatherData = apiService.getFutureWeather(i)
                tempList.add(weatherData.weather.temp)
            }
            DataResult.Success(calculateDeviation(tempList))
        } catch (e: Exception) {
            Log.w(TAG, e.toString())
            DataResult.Failure(e)
        }
}