package com.twitter.challenge.helpers;

import kotlin.math.pow

class TemperatureConverter {
    companion object {
        /**
         * Converts temperature in Celsius to temperature in Fahrenheit.
         *
         * @param temperatureInCelsius Temperature in Celsius to convert.
         * @return Temperature in Fahrenheit.
         */
        fun celsiusToFahrenheit(temperatureInCelsius: Float) = temperatureInCelsius * 1.8f + 32

        /**
         * Get deviation from temperatures
         */
        fun calculateDeviation(temperatureList: List<Float>): Float {
            val avg = temperatureList.average().toFloat()
            var sum = 0f
            temperatureList.forEach {
                sum += (avg - it).pow(2)
            }

            return (sum / (NUM_FUTURE_DAYS - 1)).pow(0.5f).round(2)
        }
    }
}
