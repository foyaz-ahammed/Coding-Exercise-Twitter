package com.twitter.challenge

import com.twitter.challenge.helpers.round
import junit.framework.Assert.assertEquals
import org.junit.Test

class HelperFunctionTest {
    @Test
    fun checkRound() {
        assertEquals(1.1234f.round(3), 1.123f)
        assertEquals(1.1234f.round(2), 1.12f)
        assertEquals(1.1f.round(2), 1.1f)
        assertEquals(0.003f.round(1), 0f)
        assertEquals(0.003f.round(2), 0f)
    }
}