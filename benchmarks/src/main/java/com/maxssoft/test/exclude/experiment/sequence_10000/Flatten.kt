package com.maxssoft.test.exclude.experiment.sequence_10000

import com.maxssoft.func.createListOfList
import com.maxssoft.func.flatten_collection
import com.maxssoft.func.flatten_sequence
import com.maxssoft.func.flatten_sequence_optimized
import com.maxssoft.func.flatten_stream
import com.maxssoft.test.factory.WARN_UP_ITERATIONS
import com.maxssoft.test.factory.WARN_UP_TIME
import com.maxssoft.test.factory.collectBlackHole
import com.maxssoft.test.factory.collectSum
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
class Flatten {

    private val internalCount = 10

    private lateinit var originCollection_10_000: List<List<Int?>>

    @Setup
    fun setup() {
        originCollection_10_000 = createListOfList(10_000, internalCount)
    }

    @Benchmark
    fun flatten_10000_rec_sequence(blackHole: Blackhole) {
        flatten_sequence(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun flatten_10000_rec_sequence_opt(blackHole: Blackhole) {
        flatten_sequence_optimized(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun flatten_10000_rec_collection(blackHole: Blackhole) {
        flatten_collection(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun flatten_10000_rec_stream(blackHole: Blackhole) {
        flatten_stream(originCollection_10_000).collectSum(blackHole)
    }
}
