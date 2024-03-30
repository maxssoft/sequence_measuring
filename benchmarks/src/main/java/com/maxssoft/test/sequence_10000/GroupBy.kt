package com.maxssoft.test.sequence_10000

import com.maxssoft.func.createIntList
import com.maxssoft.func.groupBy_collection_10
import com.maxssoft.func.groupBy_collection_90
import com.maxssoft.func.groupBy_sequence_10
import com.maxssoft.func.groupBy_sequence_90
import com.maxssoft.func.groupBy_stream_10
import com.maxssoft.func.groupBy_stream_90
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
class GroupBy {

    private lateinit var originCollection_10_000: List<Int?>

    @Setup
    fun setup() {
        originCollection_10_000 = createIntList(10_000)
    }

    @Benchmark
    fun groupBy_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        groupBy_sequence_90(originCollection_10_000).keys.collectSum(blackHole)
    }

    @Benchmark
    fun groupBy_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        groupBy_stream_90(originCollection_10_000).keys.collectSum(blackHole)
    }

    @Benchmark
    fun groupBy_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        groupBy_collection_90(originCollection_10_000).keys.collectSum(blackHole)
    }

    @Benchmark
    fun groupBy_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        groupBy_sequence_10(originCollection_10_000).keys.collectSum(blackHole)
    }

    @Benchmark
    fun groupBy_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        groupBy_stream_10(originCollection_10_000).keys.collectSum(blackHole)
    }

    @Benchmark
    fun groupBy_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        groupBy_collection_10(originCollection_10_000).keys.collectSum(blackHole)
    }
}
