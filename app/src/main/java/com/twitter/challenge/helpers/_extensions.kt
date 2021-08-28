package com.twitter.challenge.helpers

import java.lang.Math.round
import kotlin.math.roundToInt

fun Float.round(decimals: Int): Float {
    var multiplier = 1.0f
    repeat(decimals) {
        multiplier *= 10
    }

    return (this * multiplier).roundToInt() / multiplier
}