package com.maxssoft.test.run

import com.maxssoft.func.createIntList
import com.maxssoft.func.zip_collection
import com.maxssoft.func.zip_sequence
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
class Zip {

    // TODO implementation for stream api

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
    }

    @Benchmark
    fun zip_100_rec_sequence(blackHole: Blackhole) {
        zip_sequence(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_1000_rec_sequence(blackHole: Blackhole) {
        zip_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_10000_rec_sequence(blackHole: Blackhole) {
        zip_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_50000_rec_sequence(blackHole: Blackhole) {
        zip_sequence(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_100000_rec_sequence(blackHole: Blackhole) {
        zip_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_100_rec_collection(blackHole: Blackhole) {
        zip_collection(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_1000_rec_collection(blackHole: Blackhole) {
        zip_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_10000_rec_collection(blackHole: Blackhole) {
        zip_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_50000_rec_collection(blackHole: Blackhole) {
        zip_collection(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun zip_100000_rec_collection(blackHole: Blackhole) {
        zip_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

}
