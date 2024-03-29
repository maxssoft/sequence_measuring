package com.maxssoft.test.sequence

import com.maxssoft.func.createIntList
import com.maxssoft.func.map5_collection
import com.maxssoft.func.map5_sequence
import com.maxssoft.func.map5_stream
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
class Map5 {

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
    fun map5_100_rec_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_1000_rec_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_10000_rec_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_50000_rec_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_100000_rec_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_100_rec_collection(blackHole: Blackhole) {
        map5_collection(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_1000_rec_collection(blackHole: Blackhole) {
        map5_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_10000_rec_collection(blackHole: Blackhole) {
        map5_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_50000_rec_collection(blackHole: Blackhole) {
        map5_collection(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_100000_rec_collection(blackHole: Blackhole) {
        map5_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_100_rec_stream(blackHole: Blackhole) {
        map5_stream(originCollection_100).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_1000_rec_stream(blackHole: Blackhole) {
        map5_stream(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_10000_rec_stream(blackHole: Blackhole) {
        map5_stream(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_50000_rec_stream(blackHole: Blackhole) {
        map5_stream(originCollection_50_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map5_100000_rec_stream(blackHole: Blackhole) {
        map5_stream(originCollection_100_000).collectBlackHole(blackHole)
    }

}
