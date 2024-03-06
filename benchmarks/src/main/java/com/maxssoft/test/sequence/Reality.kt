package com.maxssoft.test.sequence

import com.maxssoft.func.reality_collection
import com.maxssoft.func.reality_sequence
import com.maxssoft.func.reality_stream
import com.maxssoft.test.factory.DataFactory
import com.maxssoft.test.factory.WARN_UP_ITERATIONS
import com.maxssoft.test.factory.WARN_UP_TIME
import kotlinx.benchmark.Blackhole
import kotlinx.benchmark.Scope
import kotlinx.benchmark.Setup
import kotlinx.benchmark.State
import kotlinx.benchmark.Warmup
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Fork
import java.util.concurrent.TimeUnit


@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = WARN_UP_ITERATIONS, time = WARN_UP_TIME, timeUnit = TimeUnit.SECONDS)
class Reality {

    private lateinit var originCollection_100: DataFactory
    private lateinit var originCollection_1_000: DataFactory
    private lateinit var originCollection_10_000: DataFactory
    private lateinit var originCollection_50_000: DataFactory
    private lateinit var originCollection_100_000: DataFactory

    @Setup
    fun setup() {
        originCollection_100 = DataFactory(100)
        originCollection_1_000 = DataFactory(1_000)
        originCollection_10_000 = DataFactory(10_000)
        originCollection_50_000 = DataFactory(50_000)
        originCollection_100_000 = DataFactory(100_000)
    }

    @Benchmark
    fun reality_100_rec_sequence(blackHole: Blackhole) {
        var count = 0
        reality_sequence(originCollection_100).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_1000_rec_sequence(blackHole: Blackhole) {
        var count = 0
        reality_sequence(originCollection_1_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_10000_rec_sequence(blackHole: Blackhole) {
        var count = 0
        reality_sequence(originCollection_10_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_50000_rec_sequence(blackHole: Blackhole) {
        var count = 0
        reality_sequence(originCollection_50_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_100000_rec_sequence(blackHole: Blackhole) {
        var count = 0
        reality_sequence(originCollection_100_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_100_rec_stream(blackHole: Blackhole) {
        var count = 0
        reality_stream(originCollection_100).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_1000_rec_stream(blackHole: Blackhole) {
        var count = 0
        reality_stream(originCollection_1_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_10000_rec_stream(blackHole: Blackhole) {
        var count = 0
        reality_stream(originCollection_10_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_50000_rec_stream(blackHole: Blackhole) {
        var count = 0
        reality_stream(originCollection_50_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_100000_rec_stream(blackHole: Blackhole) {
        var count = 0
        reality_stream(originCollection_100_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_100_rec_collection(blackHole: Blackhole) {
        var count = 0
        reality_collection(originCollection_100).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_1000_rec_collection(blackHole: Blackhole) {
        var count = 0
        reality_collection(originCollection_1_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_10000_rec_collection(blackHole: Blackhole) {
        var count = 0
        reality_collection(originCollection_10_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_50000_rec_collection(blackHole: Blackhole) {
        var count = 0
        reality_collection(originCollection_50_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_100000_rec_collection(blackHole: Blackhole) {
        var count = 0
        reality_collection(originCollection_100_000).forEach { blackHole.consume(it) }
    }

}
