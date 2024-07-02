package com.maxssoft.func

import com.maxssoft.test.factory.DataFactory
import kotlinx.benchmark.Blackhole
import java.util.concurrent.atomic.AtomicInteger
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.random.Random


fun createIntList(count: Int): List<Int?> {
    return mutableListOf<Int>().apply {
        (0..count).forEach { if (it == count / 2) null else add(it) }
        shuffle()
    }
}

fun createStringList(count: Int): List<String> {
    return mutableListOf<String>().apply {
        (0..count).forEach { add(it.toString()) }
        shuffle()
    }
}

fun createListOfList(count: Int, countInternal: Int): List<List<Int?>> {
    return mutableListOf<List<Int?>>().apply {
        (0..count).forEach {
            add(createIntList(countInternal))
        }
        shuffle()
    }
}

fun random(interval: Int = 100): Int = Random.nextInt(1, interval)

fun map1_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(2) }
}

fun map1_collection(sourceCollection: List<Int?>): List<Int?> {
    val result = mutableListOf<Int?>()
    sourceCollection.iterator().forEach { result.add(it?.plus(2)) }

    return sourceCollection
        .map { it?.plus(2) }
}

fun map1_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(2) }
}

fun map2_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
}

fun map2_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
}

fun map2_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
}

fun map3_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
}

fun map3_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
}

fun map3_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
}

fun map5_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
}
fun map5_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
}

fun map5_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
}

fun map10_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
}

fun map10_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
}

fun map20_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
}

fun map20_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
}

fun map20_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
}

fun map30_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
}

fun map30_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
}

fun map30_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
}

fun map40_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
}

fun map40_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
}

fun map40_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
}

fun map50_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
        .map { it?.plus(41) }
        .map { it?.plus(42) }
        .map { it?.plus(43) }
        .map { it?.plus(44) }
        .map { it?.plus(45) }
        .map { it?.plus(46) }
        .map { it?.plus(47) }
        .map { it?.plus(48) }
        .map { it?.plus(49) }
        .map { it?.plus(50) }
}

fun map50_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
        .map { it?.plus(41) }
        .map { it?.plus(42) }
        .map { it?.plus(43) }
        .map { it?.plus(44) }
        .map { it?.plus(45) }
        .map { it?.plus(46) }
        .map { it?.plus(47) }
        .map { it?.plus(48) }
        .map { it?.plus(49) }
        .map { it?.plus(50) }
}

fun map50_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
        .map { it?.plus(41) }
        .map { it?.plus(42) }
        .map { it?.plus(43) }
        .map { it?.plus(44) }
        .map { it?.plus(45) }
        .map { it?.plus(46) }
        .map { it?.plus(47) }
        .map { it?.plus(48) }
        .map { it?.plus(49) }
        .map { it?.plus(50) }
}

fun map80_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
        .map { it?.plus(41) }
        .map { it?.plus(42) }
        .map { it?.plus(43) }
        .map { it?.plus(44) }
        .map { it?.plus(45) }
        .map { it?.plus(46) }
        .map { it?.plus(47) }
        .map { it?.plus(48) }
        .map { it?.plus(49) }
        .map { it?.plus(50) }
        .map { it?.plus(51) }
        .map { it?.plus(52) }
        .map { it?.plus(53) }
        .map { it?.plus(54) }
        .map { it?.plus(55) }
        .map { it?.plus(56) }
        .map { it?.plus(57) }
        .map { it?.plus(58) }
        .map { it?.plus(59) }
        .map { it?.plus(60) }
        .map { it?.plus(61) }
        .map { it?.plus(62) }
        .map { it?.plus(63) }
        .map { it?.plus(64) }
        .map { it?.plus(65) }
        .map { it?.plus(66) }
        .map { it?.plus(67) }
        .map { it?.plus(68) }
        .map { it?.plus(69) }
        .map { it?.plus(70) }
        .map { it?.plus(81) }
        .map { it?.plus(82) }
        .map { it?.plus(83) }
        .map { it?.plus(84) }
        .map { it?.plus(85) }
        .map { it?.plus(86) }
        .map { it?.plus(87) }
        .map { it?.plus(88) }
        .map { it?.plus(89) }
        .map { it?.plus(80) }
}

fun map80_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
        .map { it?.plus(41) }
        .map { it?.plus(42) }
        .map { it?.plus(43) }
        .map { it?.plus(44) }
        .map { it?.plus(45) }
        .map { it?.plus(46) }
        .map { it?.plus(47) }
        .map { it?.plus(48) }
        .map { it?.plus(49) }
        .map { it?.plus(50) }
        .map { it?.plus(51) }
        .map { it?.plus(52) }
        .map { it?.plus(53) }
        .map { it?.plus(54) }
        .map { it?.plus(55) }
        .map { it?.plus(56) }
        .map { it?.plus(57) }
        .map { it?.plus(58) }
        .map { it?.plus(59) }
        .map { it?.plus(60) }
        .map { it?.plus(61) }
        .map { it?.plus(62) }
        .map { it?.plus(63) }
        .map { it?.plus(64) }
        .map { it?.plus(65) }
        .map { it?.plus(66) }
        .map { it?.plus(67) }
        .map { it?.plus(68) }
        .map { it?.plus(69) }
        .map { it?.plus(70) }
        .map { it?.plus(81) }
        .map { it?.plus(82) }
        .map { it?.plus(83) }
        .map { it?.plus(84) }
        .map { it?.plus(85) }
        .map { it?.plus(86) }
        .map { it?.plus(87) }
        .map { it?.plus(88) }
        .map { it?.plus(89) }
        .map { it?.plus(80) }
}

fun map80_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
        .map { it?.plus(11) }
        .map { it?.plus(12) }
        .map { it?.plus(13) }
        .map { it?.plus(14) }
        .map { it?.plus(15) }
        .map { it?.plus(16) }
        .map { it?.plus(17) }
        .map { it?.plus(18) }
        .map { it?.plus(19) }
        .map { it?.plus(20) }
        .map { it?.plus(21) }
        .map { it?.plus(22) }
        .map { it?.plus(23) }
        .map { it?.plus(24) }
        .map { it?.plus(25) }
        .map { it?.plus(26) }
        .map { it?.plus(27) }
        .map { it?.plus(28) }
        .map { it?.plus(29) }
        .map { it?.plus(30) }
        .map { it?.plus(31) }
        .map { it?.plus(32) }
        .map { it?.plus(33) }
        .map { it?.plus(34) }
        .map { it?.plus(35) }
        .map { it?.plus(36) }
        .map { it?.plus(37) }
        .map { it?.plus(38) }
        .map { it?.plus(39) }
        .map { it?.plus(40) }
        .map { it?.plus(41) }
        .map { it?.plus(42) }
        .map { it?.plus(43) }
        .map { it?.plus(44) }
        .map { it?.plus(45) }
        .map { it?.plus(46) }
        .map { it?.plus(47) }
        .map { it?.plus(48) }
        .map { it?.plus(49) }
        .map { it?.plus(50) }
        .map { it?.plus(51) }
        .map { it?.plus(52) }
        .map { it?.plus(53) }
        .map { it?.plus(54) }
        .map { it?.plus(55) }
        .map { it?.plus(56) }
        .map { it?.plus(57) }
        .map { it?.plus(58) }
        .map { it?.plus(59) }
        .map { it?.plus(60) }
        .map { it?.plus(61) }
        .map { it?.plus(62) }
        .map { it?.plus(63) }
        .map { it?.plus(64) }
        .map { it?.plus(65) }
        .map { it?.plus(66) }
        .map { it?.plus(67) }
        .map { it?.plus(68) }
        .map { it?.plus(69) }
        .map { it?.plus(70) }
        .map { it?.plus(81) }
        .map { it?.plus(82) }
        .map { it?.plus(83) }
        .map { it?.plus(84) }
        .map { it?.plus(85) }
        .map { it?.plus(86) }
        .map { it?.plus(87) }
        .map { it?.plus(88) }
        .map { it?.plus(89) }
        .map { it?.plus(80) }
}

fun map10_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .map { it?.plus(2) }
        .map { it?.plus(3) }
        .map { it?.plus(4) }
        .map { it?.plus(5) }
        .map { it?.plus(6) }
        .map { it?.plus(7) }
        .map { it?.plus(8) }
        .map { it?.plus(9) }
        .map { it?.plus(10) }
}

fun map10_sequence_int(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .map { it?.toDouble() }
        .map { it?.toLong() }
        .map { it?.toInt() }
        .map { it?.toDouble() }
        .map { it?.toLong() }
        .map { it?.toInt() }
        .map { it?.toDouble() }
        .map { it?.toLong() }
        .map { it?.toInt() }
}

fun map10_collection_int(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .map { it?.toDouble() }
        .map { it?.toLong() }
        .map { it?.toInt() }
        .map { it?.toDouble() }
        .map { it?.toLong() }
        .map { it?.toInt() }
        .map { it?.toDouble() }
        .map { it?.toLong() }
        .map { it?.toInt() }
}
fun map10_sequence_take(sourceCollection: List<Int?>): Sequence<Int?> {
    val size = sourceCollection.size
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .take(size - 1)
        .map { it?.plus(1) }
        .take(size - 2)
        .map { it?.plus(1) }
        .take(size - 3)
        .map { it?.plus(1) }
        .take(size - 4)
        .map { it?.plus(1) }
        .take(size - 5)
}

fun map10_collection_take(sourceCollection: List<Int?>): List<Int?> {
    val size = sourceCollection.size
    return sourceCollection
        .map { it?.plus(1) }
        .take(size - 1)
        .map { it?.plus(1) }
        .take(size - 2)
        .map { it?.plus(1) }
        .take(size - 3)
        .map { it?.plus(1) }
        .take(size - 4)
        .map { it?.plus(1) }
        .take(size - 5)
}

fun filter_sequence_10(sourceCollection: List<Int?>): Sequence<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .filter { it in 0..percent10 }
}

fun filter_stream_10(sourceCollection: List<Int?>): Stream<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .filter { it in 0..percent10 }
}

fun filter_collection_10(sourceCollection: List<Int?>): List<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection
        .map { it?.plus(1) }
        .filter { it in 0..percent10 }
}

fun filter_sequence_90(sourceCollection: List<Int?>): Sequence<Int?> {
    val percent90 = (sourceCollection.size * 0.9).toInt()
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .filter { it in 0..percent90 }
}

fun filter_stream_90(sourceCollection: List<Int?>): Stream<Int?> {
    val percent90 = (sourceCollection.size * 0.9).toInt()
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .filter { it in 0..percent90 }
}

fun filter_collection_90(sourceCollection: List<Int?>): List<Int?> {
    val percent90 = (sourceCollection.size * 0.9).toInt()
    return sourceCollection
        .map { it?.plus(1) }
        .filter { it in 0..percent90 }
}

fun filter2_sequence_10(sourceCollection: List<Int?>): Sequence<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.asSequence()
        .filter { it in 0..percent10 }
}

fun filter2_stream_10(sourceCollection: List<Int?>): Stream<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.stream()
        .filter { it in 0..percent10 }
}

fun filter2_collection_10(sourceCollection: List<Int?>): List<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection
        .filter { it in 0..percent10 }
}

fun filter2_sequence_90(sourceCollection: List<Int?>): Sequence<Int?> {
    val percent90 = (sourceCollection.size * 0.9).toInt()
    return sourceCollection.asSequence()
        .filter { it in 0..percent90 }
}

fun filter2_stream_90(sourceCollection: List<Int?>): Stream<Int?> {
    val percent90 = (sourceCollection.size * 0.9).toInt()
    return sourceCollection.stream()
        .filter { it in 0..percent90 }
}

fun filter2_collection_90(sourceCollection: List<Int?>): List<Int?> {
    val percent90 = (sourceCollection.size * 0.9).toInt()
    return sourceCollection
        .filter { it in 0..percent90 }
}

class FilterRanges(val size: Int) {
    val range_1 = (size * 0.99).toInt()
    val range_2 = (size * 0.98).toInt()
    val range_3 = (size * 0.97).toInt()
    val range_4 = (size * 0.96).toInt()
    val range_5 = (size * 0.95).toInt()
    val range_6 = (size * 0.94).toInt()
    val range_7 = (size * 0.93).toInt()
    val range_8 = (size * 0.92).toInt()
    val range_9 = (size * 0.91).toInt()
    val range_10 = (size * 0.9).toInt()
    val range_11 = (size * 0.89).toInt()
    val range_12 = (size * 0.88).toInt()
    val range_13 = (size * 0.87).toInt()
    val range_14 = (size * 0.86).toInt()
    val range_15 = (size * 0.85).toInt()
    val range_16 = (size * 0.84).toInt()
    val range_17 = (size * 0.83).toInt()
    val range_18 = (size * 0.82).toInt()
    val range_19 = (size * 0.81).toInt()
    val range_20 = (size * 0.8).toInt()
    val range_21 = (size * 0.79).toInt()
    val range_22 = (size * 0.78).toInt()
    val range_23 = (size * 0.77).toInt()
    val range_24 = (size * 0.76).toInt()
    val range_25 = (size * 0.75).toInt()
    val range_26 = (size * 0.74).toInt()
    val range_27 = (size * 0.73).toInt()
    val range_28 = (size * 0.72).toInt()
    val range_29 = (size * 0.71).toInt()
    val range_30 = (size * 0.7).toInt()
    val range_31 = (size * 0.69).toInt()
    val range_32 = (size * 0.68).toInt()
    val range_33 = (size * 0.67).toInt()
    val range_34 = (size * 0.66).toInt()
    val range_35 = (size * 0.65).toInt()
    val range_36 = (size * 0.64).toInt()
    val range_37 = (size * 0.63).toInt()
    val range_38 = (size * 0.62).toInt()
    val range_39 = (size * 0.61).toInt()
    val range_40 = (size * 0.6).toInt()
    val range_41 = (size * 0.59).toInt()
    val range_42 = (size * 0.58).toInt()
    val range_43 = (size * 0.57).toInt()
    val range_44 = (size * 0.56).toInt()
    val range_45 = (size * 0.55).toInt()
    val range_46 = (size * 0.54).toInt()
    val range_47 = (size * 0.53).toInt()
    val range_48 = (size * 0.52).toInt()
    val range_49 = (size * 0.51).toInt()
    val range_50 = (size * 0.5).toInt()
    val range_51 = (size * 0.499).toInt()
    val range_52 = (size * 0.498).toInt()
    val range_53 = (size * 0.497).toInt()
    val range_54 = (size * 0.496).toInt()
    val range_55 = (size * 0.495).toInt()
    val range_56 = (size * 0.494).toInt()
    val range_57 = (size * 0.493).toInt()
    val range_58 = (size * 0.492).toInt()
    val range_59 = (size * 0.491).toInt()
    val range_60 = (size * 0.49).toInt()
    val range_61 = (size * 0.489).toInt()
    val range_62 = (size * 0.488).toInt()
    val range_63 = (size * 0.487).toInt()
    val range_64 = (size * 0.486).toInt()
    val range_65 = (size * 0.485).toInt()
    val range_66 = (size * 0.484).toInt()
    val range_67 = (size * 0.483).toInt()
    val range_68 = (size * 0.482).toInt()
    val range_69 = (size * 0.481).toInt()
    val range_70 = (size * 0.48).toInt()
    val range_71 = (size * 0.479).toInt()
    val range_72 = (size * 0.478).toInt()
    val range_73 = (size * 0.477).toInt()
    val range_74 = (size * 0.476).toInt()
    val range_75 = (size * 0.475).toInt()
    val range_76 = (size * 0.474).toInt()
    val range_77 = (size * 0.473).toInt()
    val range_78 = (size * 0.472).toInt()
    val range_79 = (size * 0.471).toInt()
    val range_80 = (size * 0.47).toInt()
}

fun filter_sequence_1r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
}

fun filter_sequence_2r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
}

fun filter_sequence_3r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
}

fun filter_sequence_5r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
}

fun filter_sequence_10r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
}

fun filter_sequence_20r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
}

fun filter_sequence_30r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
}

fun filter_sequence_50r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
        .filter { it in 0..ranges.range_31 }
        .filter { it in 0..ranges.range_32 }
        .filter { it in 0..ranges.range_33 }
        .filter { it in 0..ranges.range_34 }
        .filter { it in 0..ranges.range_35 }
        .filter { it in 0..ranges.range_36 }
        .filter { it in 0..ranges.range_37 }
        .filter { it in 0..ranges.range_38 }
        .filter { it in 0..ranges.range_39 }
        .filter { it in 0..ranges.range_40 }
        .filter { it in 0..ranges.range_41 }
        .filter { it in 0..ranges.range_42 }
        .filter { it in 0..ranges.range_43 }
        .filter { it in 0..ranges.range_44 }
        .filter { it in 0..ranges.range_45 }
        .filter { it in 0..ranges.range_46 }
        .filter { it in 0..ranges.range_47 }
        .filter { it in 0..ranges.range_48 }
        .filter { it in 0..ranges.range_49 }
        .filter { it in 0..ranges.range_50 }
}

fun filter_sequence_80r(sourceCollection: List<Int?>): Sequence<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.asSequence()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
        .filter { it in 0..ranges.range_31 }
        .filter { it in 0..ranges.range_32 }
        .filter { it in 0..ranges.range_33 }
        .filter { it in 0..ranges.range_34 }
        .filter { it in 0..ranges.range_35 }
        .filter { it in 0..ranges.range_36 }
        .filter { it in 0..ranges.range_37 }
        .filter { it in 0..ranges.range_38 }
        .filter { it in 0..ranges.range_39 }
        .filter { it in 0..ranges.range_40 }
        .filter { it in 0..ranges.range_41 }
        .filter { it in 0..ranges.range_42 }
        .filter { it in 0..ranges.range_43 }
        .filter { it in 0..ranges.range_44 }
        .filter { it in 0..ranges.range_45 }
        .filter { it in 0..ranges.range_46 }
        .filter { it in 0..ranges.range_47 }
        .filter { it in 0..ranges.range_48 }
        .filter { it in 0..ranges.range_49 }
        .filter { it in 0..ranges.range_50 }
        .filter { it in 0..ranges.range_51 }
        .filter { it in 0..ranges.range_52 }
        .filter { it in 0..ranges.range_53 }
        .filter { it in 0..ranges.range_54 }
        .filter { it in 0..ranges.range_55 }
        .filter { it in 0..ranges.range_56 }
        .filter { it in 0..ranges.range_57 }
        .filter { it in 0..ranges.range_58 }
        .filter { it in 0..ranges.range_59 }
        .filter { it in 0..ranges.range_60 }
        .filter { it in 0..ranges.range_61 }
        .filter { it in 0..ranges.range_62 }
        .filter { it in 0..ranges.range_63 }
        .filter { it in 0..ranges.range_64 }
        .filter { it in 0..ranges.range_65 }
        .filter { it in 0..ranges.range_66 }
        .filter { it in 0..ranges.range_67 }
        .filter { it in 0..ranges.range_68 }
        .filter { it in 0..ranges.range_69 }
        .filter { it in 0..ranges.range_70 }
        .filter { it in 0..ranges.range_71 }
        .filter { it in 0..ranges.range_72 }
        .filter { it in 0..ranges.range_73 }
        .filter { it in 0..ranges.range_74 }
        .filter { it in 0..ranges.range_75 }
        .filter { it in 0..ranges.range_76 }
        .filter { it in 0..ranges.range_77 }
        .filter { it in 0..ranges.range_78 }
        .filter { it in 0..ranges.range_79 }
        .filter { it in 0..ranges.range_80 }
}

fun filter_collection_1r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
}

fun filter_collection_2r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
}

fun filter_collection_3r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
}

fun filter_collection_5r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
}

fun filter_collection_10r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
}

fun filter_collection_20r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
}

fun filter_collection_30r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
}

fun filter_collection_50r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
        .filter { it in 0..ranges.range_31 }
        .filter { it in 0..ranges.range_32 }
        .filter { it in 0..ranges.range_33 }
        .filter { it in 0..ranges.range_34 }
        .filter { it in 0..ranges.range_35 }
        .filter { it in 0..ranges.range_36 }
        .filter { it in 0..ranges.range_37 }
        .filter { it in 0..ranges.range_38 }
        .filter { it in 0..ranges.range_39 }
        .filter { it in 0..ranges.range_40 }
        .filter { it in 0..ranges.range_41 }
        .filter { it in 0..ranges.range_42 }
        .filter { it in 0..ranges.range_43 }
        .filter { it in 0..ranges.range_44 }
        .filter { it in 0..ranges.range_45 }
        .filter { it in 0..ranges.range_46 }
        .filter { it in 0..ranges.range_47 }
        .filter { it in 0..ranges.range_48 }
        .filter { it in 0..ranges.range_49 }
        .filter { it in 0..ranges.range_50 }
}

fun filter_collection_80r(sourceCollection: List<Int?>): Collection<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
        .filter { it in 0..ranges.range_31 }
        .filter { it in 0..ranges.range_32 }
        .filter { it in 0..ranges.range_33 }
        .filter { it in 0..ranges.range_34 }
        .filter { it in 0..ranges.range_35 }
        .filter { it in 0..ranges.range_36 }
        .filter { it in 0..ranges.range_37 }
        .filter { it in 0..ranges.range_38 }
        .filter { it in 0..ranges.range_39 }
        .filter { it in 0..ranges.range_40 }
        .filter { it in 0..ranges.range_41 }
        .filter { it in 0..ranges.range_42 }
        .filter { it in 0..ranges.range_43 }
        .filter { it in 0..ranges.range_44 }
        .filter { it in 0..ranges.range_45 }
        .filter { it in 0..ranges.range_46 }
        .filter { it in 0..ranges.range_47 }
        .filter { it in 0..ranges.range_48 }
        .filter { it in 0..ranges.range_49 }
        .filter { it in 0..ranges.range_50 }
        .filter { it in 0..ranges.range_51 }
        .filter { it in 0..ranges.range_52 }
        .filter { it in 0..ranges.range_53 }
        .filter { it in 0..ranges.range_54 }
        .filter { it in 0..ranges.range_55 }
        .filter { it in 0..ranges.range_56 }
        .filter { it in 0..ranges.range_57 }
        .filter { it in 0..ranges.range_58 }
        .filter { it in 0..ranges.range_59 }
        .filter { it in 0..ranges.range_60 }
        .filter { it in 0..ranges.range_61 }
        .filter { it in 0..ranges.range_62 }
        .filter { it in 0..ranges.range_63 }
        .filter { it in 0..ranges.range_64 }
        .filter { it in 0..ranges.range_65 }
        .filter { it in 0..ranges.range_66 }
        .filter { it in 0..ranges.range_67 }
        .filter { it in 0..ranges.range_68 }
        .filter { it in 0..ranges.range_69 }
        .filter { it in 0..ranges.range_70 }
        .filter { it in 0..ranges.range_71 }
        .filter { it in 0..ranges.range_72 }
        .filter { it in 0..ranges.range_73 }
        .filter { it in 0..ranges.range_74 }
        .filter { it in 0..ranges.range_75 }
        .filter { it in 0..ranges.range_76 }
        .filter { it in 0..ranges.range_77 }
        .filter { it in 0..ranges.range_78 }
        .filter { it in 0..ranges.range_79 }
        .filter { it in 0..ranges.range_80 }
}

fun filter_stream_1r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
}

fun filter_stream_2r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
}

fun filter_stream_3r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
}

fun filter_stream_5r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
}

fun filter_stream_10r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
}

fun filter_stream_20r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
}

fun filter_stream_30r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
}

fun filter_stream_50r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
        .filter { it in 0..ranges.range_31 }
        .filter { it in 0..ranges.range_32 }
        .filter { it in 0..ranges.range_33 }
        .filter { it in 0..ranges.range_34 }
        .filter { it in 0..ranges.range_35 }
        .filter { it in 0..ranges.range_36 }
        .filter { it in 0..ranges.range_37 }
        .filter { it in 0..ranges.range_38 }
        .filter { it in 0..ranges.range_39 }
        .filter { it in 0..ranges.range_40 }
        .filter { it in 0..ranges.range_41 }
        .filter { it in 0..ranges.range_42 }
        .filter { it in 0..ranges.range_43 }
        .filter { it in 0..ranges.range_44 }
        .filter { it in 0..ranges.range_45 }
        .filter { it in 0..ranges.range_46 }
        .filter { it in 0..ranges.range_47 }
        .filter { it in 0..ranges.range_48 }
        .filter { it in 0..ranges.range_49 }
        .filter { it in 0..ranges.range_50 }
}

fun filter_stream_80r(sourceCollection: List<Int?>): Stream<Int?> {
    val ranges = FilterRanges(sourceCollection.size)
    return sourceCollection.stream()
        .filter { it in 0..ranges.range_1 }
        .filter { it in 0..ranges.range_2 }
        .filter { it in 0..ranges.range_3 }
        .filter { it in 0..ranges.range_4 }
        .filter { it in 0..ranges.range_5 }
        .filter { it in 0..ranges.range_6 }
        .filter { it in 0..ranges.range_7 }
        .filter { it in 0..ranges.range_8 }
        .filter { it in 0..ranges.range_9 }
        .filter { it in 0..ranges.range_10 }
        .filter { it in 0..ranges.range_11 }
        .filter { it in 0..ranges.range_12 }
        .filter { it in 0..ranges.range_13 }
        .filter { it in 0..ranges.range_14 }
        .filter { it in 0..ranges.range_15 }
        .filter { it in 0..ranges.range_16 }
        .filter { it in 0..ranges.range_17 }
        .filter { it in 0..ranges.range_18 }
        .filter { it in 0..ranges.range_19 }
        .filter { it in 0..ranges.range_20 }
        .filter { it in 0..ranges.range_21 }
        .filter { it in 0..ranges.range_22 }
        .filter { it in 0..ranges.range_23 }
        .filter { it in 0..ranges.range_24 }
        .filter { it in 0..ranges.range_25 }
        .filter { it in 0..ranges.range_26 }
        .filter { it in 0..ranges.range_27 }
        .filter { it in 0..ranges.range_28 }
        .filter { it in 0..ranges.range_29 }
        .filter { it in 0..ranges.range_30 }
        .filter { it in 0..ranges.range_31 }
        .filter { it in 0..ranges.range_32 }
        .filter { it in 0..ranges.range_33 }
        .filter { it in 0..ranges.range_34 }
        .filter { it in 0..ranges.range_35 }
        .filter { it in 0..ranges.range_36 }
        .filter { it in 0..ranges.range_37 }
        .filter { it in 0..ranges.range_38 }
        .filter { it in 0..ranges.range_39 }
        .filter { it in 0..ranges.range_40 }
        .filter { it in 0..ranges.range_41 }
        .filter { it in 0..ranges.range_42 }
        .filter { it in 0..ranges.range_43 }
        .filter { it in 0..ranges.range_44 }
        .filter { it in 0..ranges.range_45 }
        .filter { it in 0..ranges.range_46 }
        .filter { it in 0..ranges.range_47 }
        .filter { it in 0..ranges.range_48 }
        .filter { it in 0..ranges.range_49 }
        .filter { it in 0..ranges.range_50 }
        .filter { it in 0..ranges.range_51 }
        .filter { it in 0..ranges.range_52 }
        .filter { it in 0..ranges.range_53 }
        .filter { it in 0..ranges.range_54 }
        .filter { it in 0..ranges.range_55 }
        .filter { it in 0..ranges.range_56 }
        .filter { it in 0..ranges.range_57 }
        .filter { it in 0..ranges.range_58 }
        .filter { it in 0..ranges.range_59 }
        .filter { it in 0..ranges.range_60 }
        .filter { it in 0..ranges.range_61 }
        .filter { it in 0..ranges.range_62 }
        .filter { it in 0..ranges.range_63 }
        .filter { it in 0..ranges.range_64 }
        .filter { it in 0..ranges.range_65 }
        .filter { it in 0..ranges.range_66 }
        .filter { it in 0..ranges.range_67 }
        .filter { it in 0..ranges.range_68 }
        .filter { it in 0..ranges.range_69 }
        .filter { it in 0..ranges.range_70 }
        .filter { it in 0..ranges.range_71 }
        .filter { it in 0..ranges.range_72 }
        .filter { it in 0..ranges.range_73 }
        .filter { it in 0..ranges.range_74 }
        .filter { it in 0..ranges.range_75 }
        .filter { it in 0..ranges.range_76 }
        .filter { it in 0..ranges.range_77 }
        .filter { it in 0..ranges.range_78 }
        .filter { it in 0..ranges.range_79 }
        .filter { it in 0..ranges.range_80 }
}

fun distinct_sequence_90_standard(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy { it }
        .last()
}

fun distinct_sequence_90_v1(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy_v1 { it }
        .last()
}

fun distinct_sequence_90_v1_withCondition(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy_v1_withCondition { it }
        .last()
}

fun distinct_sequence_90_v1_withEnumCondition(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy_v1_withEnum_condition { it }
        .last()
}

fun distinct_sequence_90_v1_withEnumWhen(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy_v1_withEnum_when { it }
        .last()
}

fun distinct_sequence_90_withoutAbstract(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy_withoutAbstract { it }
        .last()
}

fun distinct_sequence_90_withoutAbstractStateInt(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy_withoutAbstractStateInt { it }
        .last()
}

fun distinct_sequence_90_standardStateInt(sourceCollection: List<Int>): Int {
    return sourceCollection.asSequence()
        .map { it * 90 / 100 }
        .distinctBy_standardStateInt { it }
        .last()
}

fun distinct_sequence_90(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.let { it * 90 / 100 }  }
        .distinctBy { it }
}

fun distinct_sequence_90_optimized(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.let { it * 90 / 100 }  }
        .distinctBy_v1_withCondition { it }
}

fun distinct_collection_90(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.let { it * 90 / 100 }  }
        .distinctBy { it }
}

fun distinct_stream_90(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.let { it * 90 / 100 }  }
        .distinct()
}

fun distinct_sequence_10(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.let { it * 10 / 100 }  }
        .distinctBy { it }
}

fun distinct_sequence_10_optimized(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.let { it * 10 / 100 }  }
        .distinctBy_v1_withCondition { it }
}

fun distinct_collection_10(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.let { it * 10 / 100 }  }
        .distinctBy { it }
}

fun distinct_stream_10(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.let { it * 10 / 100 }  }
        .distinct()
}

fun distinct2_sequence_90(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .distinctBy { it }
}

fun distinct2_sequence_90_optimized(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .distinctBy_v1_withCondition { it }
}

fun distinct2_collection_90(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .distinctBy { it }
}

fun distinct2_stream_90(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .distinct()
}

fun distinct2_sequence_10(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .distinctBy { it }
}

fun distinct2_sequence_10_optimized(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .distinctBy_v1_withCondition { it }
}

fun distinct2_collection_10(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .distinctBy { it }
}

fun distinct2_stream_10(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .distinct()
}

fun sort_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .sortedByDescending { it }
}

fun sort_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .sorted()
}

fun sort_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .sortedByDescending { it }
}

fun sort2_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .sortedByDescending { it }
}

fun sort2_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .sorted()
}

fun sort2_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .sortedByDescending { it }
}

fun flatten_sequence(sourceCollection: List<List<Int?>>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it }
        .flatten()
}

fun flatten_sequence_optimized(sourceCollection: List<List<Int?>>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it }
        .flatten_v2()
}

fun flatten_stream(sourceCollection: List<List<Int?>>): List<Int?> {
    return sourceCollection.stream()
        .map { it }
        .flatMap { it.stream() }
        .collect(Collectors.toList())
}

fun flatten_collection(sourceCollection: List<List<Int?>>): List<Int?> {
    return sourceCollection
        .map { it }
        .flatten()
}

fun flatten2_sequence(sourceCollection: List<List<Int?>>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .flatten()
}

fun flatten2_sequence_optimized(sourceCollection: List<List<Int?>>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .flatten_v2()
}

fun flatten2_stream(sourceCollection: List<List<Int?>>): List<Int?> {
    return sourceCollection.stream()
        .flatMap { it.stream() }
        .collect(Collectors.toList())
}

fun flatten2_collection(sourceCollection: List<List<Int?>>): List<Int?> {
    return sourceCollection
        .flatten()
}

fun flatten_sequence_standard(sourceCollection: List<List<Int?>>): Int {
    return sourceCollection.asSequence()
        .flatten()
        .last() ?: 0
}

fun flatten_sequence_v2(sourceCollection: List<List<Int?>>): Int {
    return sourceCollection.asSequence()
        .flatten_v2()
        .last() ?: 0
}

fun flatten_sequence_standard_with_notnull(sourceCollection: List<List<Int?>>): Int {
    return sourceCollection.asSequence()
        .flatten_standard_withNotNull()
        .last() ?: 0
}

fun flatten_sequence_standard_with_state(sourceCollection: List<List<Int?>>): Int {
    return sourceCollection.asSequence()
        .flatten_standard_withState()
        .last() ?: 0
}

fun drop_sequence(sourceCollection: List<Int?>, percent: Int): Sequence<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .drop(count)
}

fun drop_stream(sourceCollection: List<Int?>, percent: Int): Stream<Int?> {
    val count = sourceCollection.size * percent / 100L
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .skip(count)
}

fun drop_collection(sourceCollection: List<Int?>, percent: Int): List<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection
        .map { it?.plus(1) }
        .drop(count)
}

fun drop2_sequence(sourceCollection: List<Int?>, percent: Int): Sequence<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection.asSequence()
        .drop(count)
}

fun drop2_stream(sourceCollection: List<Int?>, percent: Int): Stream<Int?> {
    val count = sourceCollection.size * percent / 100L
    return sourceCollection.stream()
        .skip(count)
}

fun drop2_collection(sourceCollection: List<Int?>, percent: Int): List<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection
        .drop(count)
}

fun take_sequence(sourceCollection: List<Int?>, percent: Int): Sequence<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .take(count)
}

fun take_stream(sourceCollection: List<Int?>, percent: Int): Stream<Int?> {
    val count = sourceCollection.size * percent / 100L
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .limit(count)
}

fun take_collection(sourceCollection: List<Int?>, percent: Int): List<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection
        .map { it?.plus(1) }
        .take(count)
}

fun take2_sequence(sourceCollection: List<Int?>, percent: Int): Sequence<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection.asSequence()
        .take(count)
}

fun take2_stream(sourceCollection: List<Int?>, percent: Int): Stream<Int?> {
    val count = sourceCollection.size * percent / 100L
    return sourceCollection.stream()
        .limit(count)
}

fun take2_collection(sourceCollection: List<Int?>, percent: Int): List<Int?> {
    val count = sourceCollection.size * percent / 100
    return sourceCollection
        .take(count)
}

fun takeWhile_sequence(sourceCollection: List<Int?>, value: Int): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .takeWhile { (it ?: 0) < value }
}

fun takeWhile_collection(sourceCollection: List<Int?>, value: Int): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .takeWhile { (it ?: 0) < value }
}

fun groupBy_sequence_90(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .groupBy { (it ?: 1) * 90 / 100 }
}

fun groupBy_stream_90(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .collect(Collectors.groupingBy { (it ?: 1) * 90 / 100 })
}

fun groupBy_collection_90(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection
        .map { it?.plus(1) }
        .groupBy { (it ?: 1) * 90 / 100 }
}

fun groupBy_sequence_10(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .groupBy { (it ?: 1) * 10 / 100 }
}

fun groupBy_stream_10(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .collect(Collectors.groupingBy { (it ?: 1) * 10 / 100 })
}

fun groupBy_collection_10(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection
        .map { it?.plus(1) }
        .groupBy { (it ?: 1) * 10 / 100 }
}

fun groupBy2_sequence_90(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.asSequence()
        .groupBy { (it ?: 1) * 90 / 100 }
}

fun groupBy2_stream_90(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.stream()
        .collect(Collectors.groupingBy { (it ?: 1) * 90 / 100 })
}

fun groupBy2_collection_90(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection
        .groupBy { (it ?: 1) * 90 / 100 }
}

fun groupBy2_sequence_10(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.asSequence()
        .groupBy { (it ?: 1) * 10 / 100 }
}

fun groupBy2_stream_10(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection.stream()
        .collect(Collectors.groupingBy { (it ?: 1) * 10 / 100 })
}

fun groupBy2_collection_10(sourceCollection: List<Int?>): Map<Int, List<Int?>> {
    return sourceCollection
        .groupBy { (it ?: 1) * 10 / 100 }
}

fun associateBy_sequence(sourceCollection: List<Int?>): Map<Int, Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .associateBy { (it ?: 1)  * 10 / 100 }
}

fun associateBy_collection(sourceCollection: List<Int?>): Map<Int, Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .associateBy { (it ?: 1)  * 10 / 100 }
}

fun plus_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .plus(sourceCollection)
}

fun plus_sequence_opt(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .plus_v2 ( sourceCollection )
}

fun plus_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return Stream.concat(sourceCollection.stream().map { it?.plus(1) }, sourceCollection.stream())
}

fun plus_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .plus(sourceCollection)
}

fun plus2_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .plus(sourceCollection)
}

fun plus2_sequence_opt(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .plus_v2(sourceCollection)
}

fun plus2_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return Stream.concat(sourceCollection.stream(), sourceCollection.stream())
}

fun plus2_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .plus(sourceCollection)
}

fun minus_sequence(sourceCollection: List<Int?>, minusCollection: Set<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .minus(minusCollection)
}

fun minus_stream(sourceCollection: List<Int?>, minusCollection: Set<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .filter { !minusCollection.contains(it) }
}

fun minus_collection(sourceCollection: List<Int?>, minusCollection: Set<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .minus(minusCollection)
}

fun minus2_sequence(sourceCollection: List<Int?>, minusCollection: Set<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .minus(minusCollection)
}

fun minus2_stream(sourceCollection: List<Int?>, minusCollection: Set<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .filter { !minusCollection.contains(it) }
}

fun minus2_collection(sourceCollection: List<Int?>, minusCollection: Set<Int?>): List<Int?> {
    return sourceCollection
        .minus(minusCollection)
}

fun chunked_sequence(sourceCollection: List<Int?>, count: Int): List<List<Int?>> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .chunked(count)
        .toList()
}

fun chunked_stream(sourceCollection: List<Int?>, count: Int): List<List<Int?>> {
    val counter = AtomicInteger(0)
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .collect(Collectors.groupingBy { counter.getAndIncrement() / count })
            .values.toList()
}

fun chunked_collection(sourceCollection: List<Int?>, count: Int): List<List<Int?>> {
    return sourceCollection
        .map { it?.plus(1) }
        .chunked(count)
}

fun zip_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .zip(sourceCollection.asSequence()) { v1, v2 -> (v1 ?: 0) + (v2 ?: 1) }
}

fun zip_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .zip(sourceCollection) { v1, v2 -> (v1 ?: 0) + (v2 ?: 1) }
}

fun test_sequence(sourceCollection: List<Int>): List<Int> {
    return sourceCollection.asSequence()
        .map { it }
        .plus(sourceCollection)
        .toList()
}

fun demo_sequence(sourceCollection: List<Int>): List<Int> {

    sourceCollection.asSequence()
        .map { it + 1 }
        .map { it + 2 }
        .map { it + 3 }
        .toList()

    val resultIterator =
        MapIterator(
            { it + 3 },
            MapIterator(
                { it + 2 },
                MapIterator(
                    { it + 1 },
                    sourceCollection.iterator()
                )
            )
        )

    val result = mutableListOf<Int>()
    resultIterator.forEach { result.add(it) }


    return result
}

inline fun map(sourceCollection: List<Int>, transform: (Int) -> Int): List<Int> {
    HashMap<String, String>()
    val result = ArrayList<Int>(sourceCollection.size)
    sourceCollection.forEach { result.add(it + 1) }
    return result
}

class MapIterator(transform: (Int) -> Int, iterator: Iterator<Int>) : Iterator<Int> {
    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Int {
        TODO("Not yet implemented")
    }
}

fun crazy_sequence_10(sourceCollection: List<Int?>): Sequence<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.asSequence()
        .map { if ((it ?: 1) % percent10 == 0) null else it }
        .filterNotNull()
        .map { it * 10 / 100 }
        .distinctBy { it }
        .map { it + 1 }
}

fun crazy_stream_10(sourceCollection: List<Int?>): Stream<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.stream()
        .map { if ((it ?: 1) % percent10 == 0) null else it }
        .filter { it != null }
        .map { it ?: 0  * 10 / 100 }
        .distinct()
        .map { it + 1 }
}
fun crazy_collection_10(sourceCollection: List<Int?>): List<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection
        .map { if ((it ?: 1) % percent10 == 0) null else it }
        .filterNotNull()
        .map { it * 10 / 100 }
        .distinctBy { it }
        .map { it + 1 }
}

fun crazy_sequence_90(sourceCollection: List<Int?>): Sequence<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.asSequence()
        .map { if ((it ?: 1) % percent10 == 0) null else it }
        .filterNotNull()
        .map { it * 90 / 100 }
        .distinctBy { it }
        .map { it + 1 }
}

fun crazy_stream_90(sourceCollection: List<Int?>): Stream<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection.stream()
        .map { if ((it ?: 1) % percent10 == 0) null else it }
        .filter { it != null }
        .map { it ?: 0  * 90 / 100 }
        .distinct()
        .map { it + 1 }
}

fun crazy_collection_90(sourceCollection: List<Int?>): List<Int?> {
    val percent10 = (sourceCollection.size * 0.1).toInt()
    return sourceCollection
        .map { if ((it ?: 1) % percent10 == 0) null else it }
        .filterNotNull()
        .map { it * 90 / 100 }
        .distinctBy { it }
        .map { it + 1 }
}

fun crazy_sequence(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .sortedBy { it }
        .map { it?.let { it % 3 } }
        .filter { it ?: 0  > 0 }
        .map { it?.plus(1) }
        .distinctBy { it }
}

fun crazy_sequence_opt(sourceCollection: List<Int?>): Sequence<Int?> {
    return sourceCollection.asSequence()
        .map { it?.plus(1) }
        .sortedBy { it }
        .map { it?.let { it % 3 } }
        .filter { it ?: 0  > 0 }
        .map { it?.plus(1) }
        .distinctBy_v1 { it }
}

fun crazy_stream(sourceCollection: List<Int?>): Stream<Int?> {
    return sourceCollection.stream()
        .map { it?.plus(1) }
        .sorted()
        .map { it?.let { it % 3 } }
        .filter { it ?: 0  > 0 }
        .map { it?.plus(1) }
        .distinct()
}

fun crazy_collection(sourceCollection: List<Int?>): List<Int?> {
    return sourceCollection
        .map { it?.plus(1) }
        .sortedBy { it }
        .map { it?.let { it % 3 } }
        .filter { it ?: 0  > 0 }
        .map { it?.plus(1) }
        .distinctBy { it }
}

// return list of products with default photo Pair<productUid, photoUrl>
fun reality_sequence(realData: DataFactory): Sequence<Pair<String, String?>> {
    return realData.sessionManager.productCategories
        .asSequence()
        .map { it.categoryName }
        .mapNotNull { realData.productRepository.getCategoryProducts(it) }
        .flatten()
        .distinctBy { it.productUid }
        .map { product ->
            product.productUid to product.photos.firstOrNull { it.isDefault }?.url
        }
}

fun reality_stream(realData: DataFactory): Stream<Pair<String, String?>> {
    return realData.sessionManager.productCategories
        .stream()
        .map { it.categoryName }
        .filter { it != null }
        .map { realData.productRepository.getCategoryProducts(it) }
        .flatMap { it?.stream() }
        .distinct()
        .map { product ->
            product.productUid to product.photos.firstOrNull { it.isDefault }?.url
        }

}

fun reality_collection(realData: DataFactory): List<Pair<String, String?>> {
    return realData.sessionManager.productCategories
        .map { it.categoryName }
        .mapNotNull { realData.productRepository.getCategoryProducts(it) }
        .flatten()
        .distinctBy { it.productUid }
        .map { product ->
            product.productUid to product.photos.firstOrNull { it.isDefault }?.url
        }
}

//----------------------------------------------------------------------------------
fun example() {
    val sourceCollection = listOf<Int>()

    sourceCollection.asSequence()
        .map { it + 1 }
        .map { it + 1 }
        .map { it + 1 }
        .toList()

    val resultIterator =
        MapIterator(
            { it + 3 },
            MapIterator(
                { it + 2 },
                MapIterator(
                    { it + 1 },
                    sourceCollection.iterator()
                )
            )
        )

    val result = mutableListOf<Int>()
    resultIterator.forEach { result.add(it) }

    val transformedValue = resultIterator.next()
    /**
     * newValue = resultIterator.next() = 7
     *                           |
     *                           mapIterator3.next() + 3 = 4 + 3 = 7
     *                                        |
     *                                        mapIterator2.next() + 2 = 2 + 2 = 4
     *                                                     |
     *                                                     mapIterator1.next() + 1 = 1 + 1 = 2
     *                                                                  |
     *                                                                  sourceCollection.iterator().next() = 1
     */

    sequenceOf(5, 4, 3, 2, 1)
        .map { it + 1 }
        .filter { it % 2 == 0 }
        .sortedBy { it }
        .map { it - 1 }
        .map { it + 1 }

    // Ленивые преобразования идущие до sort
    val list = sequenceOf(5, 4, 3, 2, 1)
        .map { it + 1 }
        .filter { it % 2 == 0 }
        .toList()

    // Сохраняем последовательность в список и сортируем ее
    val newSequences = list.sortedBy { it }.asSequence()

    // Ленивые преобразования идущие после sort
    val resultSort = newSequences
        .map { it - 1 }
        .map { it + 1 }
}

fun testExample(sourceCollection: List<Int?>, blackHole: Blackhole) {
    val percent10 = 10
    sourceCollection.asSequence()
        .map { it?.plus(1) }
        .plus(sourceCollection)
        .forEach { blackHole.consume(it) }
}

fun testExample_reality(realData: DataFactory, blackHole: Blackhole) {
    realData.sessionManager.productCategories.asSequence()
        .map { it.categoryName }
        .mapNotNull { realData.productRepository.getCategoryProducts(it) }
        .flatten()
        .distinctBy { it.productUid }
        .map { product ->
            product.productUid to product.photos.firstOrNull { it.isDefault }?.url
        }
        .forEach { blackHole.consume(it) }
}
