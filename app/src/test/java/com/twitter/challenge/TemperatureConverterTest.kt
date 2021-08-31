package com.twitter.challenge

import com.twitter.challenge.helpers.TemperatureConverter
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TemperatureConverterTest {
    @Test
    fun checkDeviation() {
        assertEquals(getDeviation(10f, 10f, 10f, 10f, 10f),0f)
        assertEquals(getDeviation(20f, 21f, 22f, 23f, 24f),1.58f)
        assertEquals(getDeviation(10f, 12f, 23f, 23f, 16f),6.06f)
        assertEquals(getDeviation(-10f, -12f, -23f, -23f, -16f),6.06f)
        assertEquals(getDeviation(-10f, -11f, -10f, -11f, -10f),0.55f)

        //If the count is zero or one, suppose the expected result is 0
        assertEquals(getDeviation(),0f)
        assertEquals(getDeviation(10f),0f)

        assertEquals(getDeviation(10f, 12f),1.41f)
        assertEquals(getDeviation(10f, 12f, 14f),2f)
        assertEquals(getDeviation(10f, 12f, 14f, 16f),2.58f)
        assertEquals(getDeviation(10f, 12f, 14f, 16f, 18f),3.16f)
    }

    private fun getDeviation(vararg elements: Float) = TemperatureConverter.calculateDeviation(elements.asList())
}