package com.maxssoft.test.run

import com.maxssoft.func.createIntList
import com.maxssoft.func.distinct_collection_10
import com.maxssoft.func.distinct_collection_90
import com.maxssoft.func.distinct_sequence_10
import com.maxssoft.func.distinct_sequence_10_optimized
import com.maxssoft.func.distinct_sequence_90
import com.maxssoft.func.distinct_sequence_90_optimized
import com.maxssoft.func.distinct_stream_10
import com.maxssoft.func.distinct_stream_90
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

@State(Scope.Benchmark) // Scope.Benchmark
@Fork(1)
@Warmup(iterations = WARN_UP_ITERATIONS, time = WARN_UP_TIME, timeUnit = TimeUnit.SECONDS)
class Distinct {

    private lateinit var originCollection_100: List<Int?>
    private lateinit var originCollection_1_000: List<Int?>
    private lateinit var originCollection_10_000: List<Int?>
    private lateinit var originCollection_50_000: List<Int?>
    private lateinit var originCollection_100_000: List<Int?>

    @Setup
    fun setup() {
        originCollection_100 = createIntList(100)
        originCollection_1_000 = createIntList(1_000)
        originCollection_10_000 = createIntList(10_000)
        originCollection_50_000 = createIntList(50_000)
        originCollection_100_000 = createIntList(100_000)
        println("distinct_collection_90 = 1.000 -> ${distinct_collection_90(originCollection_1_000).size}")
        println("distinct_collection_10 = 1.000 -> ${distinct_collection_10(originCollection_1_000).size}")
    }

    @Benchmark
    fun distinct_90_percentage_100_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_90(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_1000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_90(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_90(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_50000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_90(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_100000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_90(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_100_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_90_optimized(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_1000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_90_optimized(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_10000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_90_optimized(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_50000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_90_optimized(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_100000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_90_optimized(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_100_rec_collection(blackHole: Blackhole) {
        distinct_collection_90(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_1000_rec_collection(blackHole: Blackhole) {
        distinct_collection_90(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        distinct_collection_90(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_50000_rec_collection(blackHole: Blackhole) {
        distinct_collection_90(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_100000_rec_collection(blackHole: Blackhole) {
        distinct_collection_90(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_100_rec_stream(blackHole: Blackhole) {
        distinct_stream_90(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_1000_rec_stream(blackHole: Blackhole) {
        distinct_stream_90(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        distinct_stream_90(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_50000_rec_stream(blackHole: Blackhole) {
        distinct_stream_90(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_90_percentage_100000_rec_stream(blackHole: Blackhole) {
        distinct_stream_90(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_10(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_1000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_10(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_10(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_50000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_10(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100000_rec_sequence(blackHole: Blackhole) {
        distinct_sequence_10(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_10_optimized(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_1000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_10_optimized(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_10000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_10_optimized(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_50000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_10_optimized(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100000_rec_sequence_opt(blackHole: Blackhole) {
        distinct_sequence_10_optimized(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100_rec_collection(blackHole: Blackhole) {
        distinct_collection_10(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_1000_rec_collection(blackHole: Blackhole) {
        distinct_collection_10(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        distinct_collection_10(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_50000_rec_collection(blackHole: Blackhole) {
        distinct_collection_10(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100000_rec_collection(blackHole: Blackhole) {
        distinct_collection_10(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100_rec_stream(blackHole: Blackhole) {
        distinct_stream_10(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_1000_rec_stream(blackHole: Blackhole) {
        distinct_stream_10(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        distinct_stream_10(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_50000_rec_stream(blackHole: Blackhole) {
        distinct_stream_10(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct_10_percentage_100000_rec_stream(blackHole: Blackhole) {
        distinct_stream_10(originCollection_100_000).collectBlackHole(blackHole)
    }

}
