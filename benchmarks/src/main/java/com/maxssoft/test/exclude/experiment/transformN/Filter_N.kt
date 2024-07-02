package com.maxssoft.test.exclude.experiment.transformN

import com.maxssoft.func.createIntList
import com.maxssoft.func.filter_collection_10r
import com.maxssoft.func.filter_collection_1r
import com.maxssoft.func.filter_collection_20r
import com.maxssoft.func.filter_collection_2r
import com.maxssoft.func.filter_collection_30r
import com.maxssoft.func.filter_collection_3r
import com.maxssoft.func.filter_collection_50r
import com.maxssoft.func.filter_collection_5r
import com.maxssoft.func.filter_collection_80r
import com.maxssoft.func.filter_sequence_10r
import com.maxssoft.func.filter_sequence_1r
import com.maxssoft.func.filter_sequence_20r
import com.maxssoft.func.filter_sequence_2r
import com.maxssoft.func.filter_sequence_30r
import com.maxssoft.func.filter_sequence_3r
import com.maxssoft.func.filter_sequence_50r
import com.maxssoft.func.filter_sequence_5r
import com.maxssoft.func.filter_sequence_80r
import com.maxssoft.func.filter_stream_10r
import com.maxssoft.func.filter_stream_1r
import com.maxssoft.func.filter_stream_20r
import com.maxssoft.func.filter_stream_2r
import com.maxssoft.func.filter_stream_30r
import com.maxssoft.func.filter_stream_3r
import com.maxssoft.func.filter_stream_50r
import com.maxssoft.func.filter_stream_5r
import com.maxssoft.func.filter_stream_80r
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
class Filter_N {

    private lateinit var originCollection_10_000: List<Int?>

    @Setup
    fun setup() {
        originCollection_10_000 = createIntList(10_000)
    }

    @Benchmark
    fun filter_1r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_1r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_2r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_2r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_3r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_3r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_5r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_5r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_10r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_10r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_20r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_20r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_30r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_30r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_50r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_50r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_80r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_80r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_1r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_1r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_2r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_2r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_3r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_3r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_5r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_5r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_10r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_10r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_20r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_20r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_30r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_30r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_50r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_50r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_80r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_80r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_1r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_1r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_2r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_2r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_3r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_3r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_5r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_5r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_10r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_10r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_20r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_20r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_30r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_30r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_50r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_50r(originCollection_10_000).collectSum(blackHole)
    }

    @Benchmark
    fun filter_80r_10000_rec_stream(blackHole: Blackhole) {
        filter_stream_80r(originCollection_10_000).collectSum(blackHole)
    }
}
