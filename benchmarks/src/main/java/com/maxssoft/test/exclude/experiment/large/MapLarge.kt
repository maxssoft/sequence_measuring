package com.maxssoft.test.exclude.experiment.large

import com.maxssoft.func.createIntList
import com.maxssoft.func.map10_collection
import com.maxssoft.func.map10_sequence
import com.maxssoft.func.map10_stream
import com.maxssoft.func.map1_collection
import com.maxssoft.func.map1_sequence
import com.maxssoft.func.map1_stream
import com.maxssoft.func.map2_collection
import com.maxssoft.func.map2_sequence
import com.maxssoft.func.map2_stream
import com.maxssoft.func.map3_collection
import com.maxssoft.func.map3_sequence
import com.maxssoft.func.map3_stream
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
class MapLarge {

    private lateinit var originCollection: List<Int?>

    @Setup
    fun setup() {
        originCollection = createIntList(10_000_000)
    }

    @Benchmark
    fun map1_10_000_000_rec_sequence(blackHole: Blackhole) {
        map1_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map1_10_000_000_rec_collection(blackHole: Blackhole) {
        map1_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map1_10_000_000_rec_stream(blackHole: Blackhole) {
        map1_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map2_10_000_000_rec_sequence(blackHole: Blackhole) {
        map2_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map2_10_000_000_rec_collection(blackHole: Blackhole) {
        map2_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map2_10_000_000_rec_stream(blackHole: Blackhole) {
        map2_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map3_10_000_000_rec_sequence(blackHole: Blackhole) {
        map3_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map3_10_000_000_rec_collection(blackHole: Blackhole) {
        map3_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map3_10_000_000_rec_stream(blackHole: Blackhole) {
        map3_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map5_10_000_000_rec_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map5_10_000_000_rec_collection(blackHole: Blackhole) {
        map5_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map5_10_000_000_rec_stream(blackHole: Blackhole) {
        map5_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map10_10_000_000_rec_sequence(blackHole: Blackhole) {
        map10_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map10_10_000_000_rec_collection(blackHole: Blackhole) {
        map10_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map10_10_000_000_rec_stream(blackHole: Blackhole) {
        map10_stream(originCollection).collectSum(blackHole)
    }
}
