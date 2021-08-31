package com.twitter.challenge.helpers

import kotlin.math.roundToInt

fun Float.round(decimals: Int): Float {
    var multiplier = 1.0f
    repeat(decimals) {
        multiplier *= 10
    }

    return (this * multiplier).roundToInt() / multiplier
}