package com.maxssoft.test.sequence_10000

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

    private lateinit var originCollection_10_000: DataFactory

    @Setup
    fun setup() {
        originCollection_10_000 = DataFactory(10_000)
    }

    @Benchmark
    fun reality_10000_rec_sequence(blackHole: Blackhole) {
        var count = 0
        reality_sequence(originCollection_10_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_10000_rec_stream(blackHole: Blackhole) {
        var count = 0
        reality_stream(originCollection_10_000).forEach { blackHole.consume(it) }
    }

    @Benchmark
    fun reality_10000_rec_collection(blackHole: Blackhole) {
        var count = 0
        reality_collection(originCollection_10_000).forEach { blackHole.consume(it) }
    }
}
