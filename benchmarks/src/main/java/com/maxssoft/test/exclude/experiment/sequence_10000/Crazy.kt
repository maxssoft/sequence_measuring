package com.maxssoft.test.exclude.experiment.sequence_10000

import com.maxssoft.func.crazy_collection
import com.maxssoft.func.crazy_sequence
import com.maxssoft.func.crazy_sequence_opt
import com.maxssoft.func.crazy_stream
import com.maxssoft.func.createIntList
import com.maxssoft.test.factory.WARN_UP_ITERATIONS
import com.maxssoft.test.factory.WARN_UP_TIME
import com.maxssoft.test.factory.collectBlackHole
import com.maxssoft.test.factory.collectSum
import kotlinx.benchmark.Blackhole
import kotlinx.benchmark.Scope
import kotlinx.benchmark.Setup
import kotlinx.benchmark.State
import kotlinx.benchmark.Warmup
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Fork
import java.util.concurrent.TimeUnit
import java.util.stream.Stream

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = WARN_UP_ITERATIONS, time = WARN_UP_TIME, timeUnit = TimeUnit.SECONDS)
class Crazy {

    private lateinit var originCollection: List<Int?>
    private lateinit var originCollection_10_000: List<Int?>

    @Setup
    fun setup() {
        originCollection_10_000 = createIntList(10_000)
    }

    @Benchmark
    fun crazy_10000_rec_sequence(blackHole: Blackhole) {
        crazy_sequence(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun crazy_10000_rec_sequence_opt(blackHole: Blackhole) {
        crazy_sequence_opt(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun crazy_10000_rec_stream(blackHole: Blackhole) {
        crazy_stream(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun crazy_10000_rec_collection(blackHole: Blackhole) {
        crazy_collection(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun test(blackHole: Blackhole) {
        val percent10 = (originCollection.size * 0.1).toInt()
        originCollection.asSequence()
            .map { if ((it ?: 1) % percent10 == 0) null else it }
            .filter { it != null }
            .map { (it ?: 0) * 90 / 100 }
            .distinct()
            .map { it + 1 }
            .collectBlackHole(blackHole)
    }

}
