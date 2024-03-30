package com.maxssoft.test.sequence_10000

import com.maxssoft.func.createIntList
import com.maxssoft.func.sort_collection
import com.maxssoft.func.sort_sequence
import com.maxssoft.func.sort_stream
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
class Sort {

    private lateinit var originCollection_10_000: List<Int?>

    @Setup
    fun setup() {
        originCollection_10_000 = createIntList(10_000)
    }

    @Benchmark
    fun sort_10000_rec_sequence(blackHole: Blackhole) {
        sort_sequence(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun sort_10000_rec_collection(blackHole: Blackhole) {
        sort_collection(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun sort_10000_rec_stream(blackHole: Blackhole) {
        sort_stream(originCollection_10_000).collectSum(blackHole)
    }
}
