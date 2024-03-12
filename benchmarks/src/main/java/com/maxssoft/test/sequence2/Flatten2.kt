package com.maxssoft.test.sequence2

import com.maxssoft.func.createListOfList
import com.maxssoft.func.flatten2_collection
import com.maxssoft.func.flatten2_sequence
import com.maxssoft.func.flatten2_sequence_optimized
import com.maxssoft.func.flatten2_stream
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
class Flatten2 {

    private val internalCount = 10

    private lateinit var originCollection_100: List<List<Int?>>
    private lateinit var originCollection_1_000: List<List<Int?>>
    private lateinit var originCollection_10_000: List<List<Int?>>
    private lateinit var originCollection_50_000: List<List<Int?>>
    private lateinit var originCollection_100_000: List<List<Int?>>

    @Setup
    fun setup() {
        originCollection_100 = createListOfList(100, internalCount)
        originCollection_1_000 = createListOfList(1_000, internalCount)
        originCollection_10_000 = createListOfList(10_000, internalCount)
        originCollection_50_000 = createListOfList(50_000, internalCount)
        originCollection_100_000 = createListOfList(100_000, internalCount)
    }

    @Benchmark
    fun flatten2_100_rec_sequence(blackHole: Blackhole) {
        flatten2_sequence(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_1000_rec_sequence(blackHole: Blackhole) {
        flatten2_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_10000_rec_sequence(blackHole: Blackhole) {
        flatten2_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_50000_rec_sequence(blackHole: Blackhole) {
        flatten2_sequence(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_100000_rec_sequence(blackHole: Blackhole) {
        flatten2_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_100_rec_sequence_opt(blackHole: Blackhole) {
        flatten2_sequence_optimized(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_1000_rec_sequence_opt(blackHole: Blackhole) {
        flatten2_sequence_optimized(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_10000_rec_sequence_opt(blackHole: Blackhole) {
        flatten2_sequence_optimized(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_50000_rec_sequence_opt(blackHole: Blackhole) {
        flatten2_sequence_optimized(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_100000_rec_sequence_opt(blackHole: Blackhole) {
        flatten2_sequence_optimized(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_100_rec_collection(blackHole: Blackhole) {
        flatten2_collection(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_1000_rec_collection(blackHole: Blackhole) {
        flatten2_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_10000_rec_collection(blackHole: Blackhole) {
        flatten2_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_50000_rec_collection(blackHole: Blackhole) {
        flatten2_collection(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_100000_rec_collection(blackHole: Blackhole) {
        flatten2_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_100_rec_stream(blackHole: Blackhole) {
        flatten2_stream(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_1000_rec_stream(blackHole: Blackhole) {
        flatten2_stream(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_10000_rec_stream(blackHole: Blackhole) {
        flatten2_stream(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_50000_rec_stream(blackHole: Blackhole) {
        flatten2_stream(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun flatten2_100000_rec_stream(blackHole: Blackhole) {
        flatten2_stream(originCollection_100_000).collectBlackHole(blackHole)
    }

}
