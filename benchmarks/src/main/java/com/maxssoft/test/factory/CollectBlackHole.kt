package com.maxssoft.test.factory

import kotlinx.benchmark.Blackhole
import java.util.stream.Stream

fun Sequence<*>.collectBlackHole(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}

fun Stream<*>.collectBlackHole(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}

fun Iterable<*>.collectBlackHole(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}


/*
fun Stream<Int?>.collectBlackHole(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}

fun Sequence<Int?>.collectBlackHole(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}

fun Iterable<Int?>.collectBlackHole(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}

fun List<List<*>>.collectBlackHole(blackHole: Blackhole) {
    forEach { it.forEach { element -> blackHole.consume(element) } }
}

fun Stream<String>.collectBlackHoleStr(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}

fun Sequence<String>.collectBlackHoleStr(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}

fun Iterable<String>.collectBlackHoleStr(blackHole: Blackhole) {
    forEach { element->
        blackHole.consume(element)
    }
}
*/


