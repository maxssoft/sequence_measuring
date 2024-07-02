package com.maxssoft.test.exclude.experiment

import com.maxssoft.func.MemoryConsumer
import com.maxssoft.func.createIntList
import com.maxssoft.func.map5_collection
import com.maxssoft.func.map5_sequence
import com.maxssoft.func.map5_stream
import com.maxssoft.test.factory.WARN_UP_ITERATIONS
import com.maxssoft.test.factory.WARN_UP_TIME
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
class MapExample {
    private lateinit var originCollection: List<Int?>
    @Setup
    fun setup() {
        originCollection = createIntList(100_000)
    }
    @Benchmark
    fun map5_100_000_rec_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection).collectSum(blackHole)
    }
    @Benchmark
    fun map5_100_000_rec_collection(blackHole: Blackhole) {
        map5_collection(originCollection).collectSum(blackHole)
    }
}
