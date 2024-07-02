package com.maxssoft.test.exclude.experiment.sequence_10000

import com.maxssoft.func.createIntList
import com.maxssoft.func.minus_collection
import com.maxssoft.func.minus_sequence
import com.maxssoft.func.minus_stream
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
class Minus {

    private lateinit var originCollection_10_000: List<Int?>
    private lateinit var originCollection_10_perc_10_000: Set<Int?>
    private lateinit var originCollection_90_perc_10_000: Set<Int?>

    @Setup
    fun setup() {
        originCollection_10_000 = createIntList(10_000)
        originCollection_10_perc_10_000 = createIntList(1_000).toSet()
        originCollection_90_perc_10_000 = createIntList(9_000).toSet()
    }

    @Benchmark
    fun minus_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        minus_sequence(originCollection_10_000, originCollection_90_perc_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun minus_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        minus_stream(originCollection_10_000, originCollection_90_perc_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun minus_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        minus_collection(originCollection_10_000, originCollection_90_perc_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun minus_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        minus_sequence(originCollection_10_000, originCollection_10_perc_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun minus_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        minus_stream(originCollection_10_000, originCollection_10_perc_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun minus_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        minus_collection(originCollection_10_000, originCollection_10_perc_10_000).collectSum(blackHole)
    }
}
