package com.maxssoft.test.sequence_10000

import com.maxssoft.func.createIntList
import com.maxssoft.func.filter_collection_10
import com.maxssoft.func.filter_collection_90
import com.maxssoft.func.take_collection
import com.maxssoft.func.take_sequence
import com.maxssoft.func.take_stream
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
class Take {

    private lateinit var originCollection_10_000: List<Int?>

    @Setup
    fun setup() {
        originCollection_10_000 = createIntList(10_000)
    }
    
    @Benchmark
    fun take_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        take_sequence(originCollection_10_000, 90).collectSum(blackHole)
    }

    @Benchmark
    fun take_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        take_stream(originCollection_10_000, 90).collectSum(blackHole)
    }

    @Benchmark
    fun take_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        take_collection(originCollection_10_000, 90).collectSum(blackHole)
    }

    @Benchmark
    fun take_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        take_sequence(originCollection_10_000, 10).collectSum(blackHole)
    }

    @Benchmark
    fun take_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        take_stream(originCollection_10_000, 10).collectSum(blackHole)
    }

    @Benchmark
    fun take_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        take_collection(originCollection_10_000, 10).collectSum(blackHole)
    }
}
