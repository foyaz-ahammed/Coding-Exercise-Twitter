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
class ExampleUnitTest {
    @Test
    fun checkDeviation() {
        assertEquals(
            TemperatureConverter.calculateDeviation(listOf(20f, 21f, 22f, 23f, 24f)),
            1.58f)
    }
}