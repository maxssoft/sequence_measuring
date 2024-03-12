package com.maxssoft.test.experiment

import com.maxssoft.func.createIntList
import com.maxssoft.func.createListOfList
import com.maxssoft.func.distinct2_collection_10
import com.maxssoft.func.distinct2_collection_90
import com.maxssoft.func.distinct2_sequence_10
import com.maxssoft.func.distinct2_sequence_90
import com.maxssoft.func.filter2_sequence_90
import com.maxssoft.func.filter2_collection_10
import com.maxssoft.func.filter2_collection_90
import com.maxssoft.func.filter2_sequence_10
import com.maxssoft.func.flatten2_collection
import com.maxssoft.func.flatten2_sequence
import com.maxssoft.func.map1_collection
import com.maxssoft.func.map1_sequence
import com.maxssoft.func.minus2_collection
import com.maxssoft.func.minus2_sequence
import com.maxssoft.func.sort2_collection
import com.maxssoft.func.sort2_sequence
import com.maxssoft.func.take2_collection
import com.maxssoft.func.take2_sequence
import com.maxssoft.test.factory.WARN_UP_ITERATIONS
import com.maxssoft.test.factory.WARN_UP_TIME
import com.maxssoft.test.factory.collectBlackHole
import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Blackhole
import kotlinx.benchmark.Scope
import kotlinx.benchmark.Setup
import kotlinx.benchmark.State
import kotlinx.benchmark.Warmup
import org.openjdk.jmh.annotations.Fork
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = WARN_UP_ITERATIONS, time = WARN_UP_TIME, timeUnit = TimeUnit.SECONDS)
class All {

    private lateinit var originCollection_10_000: List<Int?>
    private lateinit var originCollection_10_perc_10_000: Set<Int?>
    private lateinit var originCollection_90_perc_10_000: Set<Int?>
    private lateinit var originTreeCollection_10_000: List<List<Int?>>

    @Setup
    fun setup() {
        originCollection_10_000 = createIntList(10_000)
        originCollection_10_perc_10_000 = createIntList(1_000).toSet()
        originCollection_90_perc_10_000 = createIntList(9_000).toSet()
        originTreeCollection_10_000 = createListOfList(10_000, 10)
    }

    //@Benchmark
    fun filter2_90_sequence(blackHole: Blackhole) {
        filter2_sequence_90(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun filter2_90_collection(blackHole: Blackhole) {
        filter2_collection_90(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun filter2_10_sequence(blackHole: Blackhole) {
        filter2_sequence_10(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun filter2_10_collection(blackHole: Blackhole) {
        filter2_collection_10(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun distinct2_90_sequence(blackHole: Blackhole) {
        distinct2_sequence_90(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun distinct2_90_collection(blackHole: Blackhole) {
        distinct2_collection_90(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun distinct2_10_sequence(blackHole: Blackhole) {
        distinct2_sequence_10(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun distinct2_10_collection(blackHole: Blackhole) {
        distinct2_collection_10(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun minus2_90_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_10_000, originCollection_90_perc_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun minus2_90_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_10_000, originCollection_90_perc_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun minus2_10_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_10_000, originCollection_10_perc_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun minus2_10_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_10_000, originCollection_10_perc_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun flatten2_sequence(blackHole: Blackhole) {
        flatten2_sequence(originTreeCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun flatten2_collection(blackHole: Blackhole) {
        flatten2_collection(originTreeCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun sort2_sequence(blackHole: Blackhole) {
        sort2_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun sort2_collection(blackHole: Blackhole) {
        sort2_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun take2_10_sequence(blackHole: Blackhole) {
        take2_sequence(originCollection_10_000, 10).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun take2_10_collection(blackHole: Blackhole) {
        take2_collection(originCollection_10_000, 10).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun take2_90_sequence(blackHole: Blackhole) {
        take2_sequence(originCollection_10_000, 90).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun take2_90_collection(blackHole: Blackhole) {
        take2_collection(originCollection_10_000, 90).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun map1_sequence(blackHole: Blackhole) {
        map1_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun map1_collection(blackHole: Blackhole) {
        map1_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun array_copy(blackHole: Blackhole): Int? {
        val array = ArrayList<Int?>(originCollection_10_000.size)
        originCollection_10_000.forEach { value -> array.add(value) }
        return array.last()
    }
}
