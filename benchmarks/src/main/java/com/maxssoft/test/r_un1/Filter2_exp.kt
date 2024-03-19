package com.maxssoft.test.r_un1

import com.maxssoft.func.MemoryConsumer
import com.maxssoft.func.createIntList
import com.maxssoft.func.createIntList
import com.maxssoft.func.filter_collection_10
import com.maxssoft.func.filter_collection_10r
import com.maxssoft.func.filter_collection_1r
import com.maxssoft.func.filter_collection_2r
import com.maxssoft.func.filter_collection_3r
import com.maxssoft.func.filter_collection_5r
import com.maxssoft.func.filter_collection_90
import com.maxssoft.func.filter_sequence_10
import com.maxssoft.func.filter_sequence_10r
import com.maxssoft.func.filter_sequence_1r
import com.maxssoft.func.filter_sequence_2r
import com.maxssoft.func.filter_sequence_3r
import com.maxssoft.func.filter_sequence_5r
import com.maxssoft.func.filter_sequence_90
import com.maxssoft.func.filter_stream_10
import com.maxssoft.func.filter_stream_90
import com.maxssoft.test.factory.WARN_UP_ITERATIONS
import com.maxssoft.test.factory.WARN_UP_TIME
import com.maxssoft.test.factory.collectBlackHole
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
class Filter2_exp {

    private lateinit var originCollection_100: List<Int?>
    private lateinit var originCollection_1_000: List<Int?>
    private lateinit var originCollection_10_000: List<Int?>
    private lateinit var originCollection_50_000: List<Int?>
    private lateinit var originCollection_100_000: List<Int?>

    private val memoryConsumer = MemoryConsumer()

    @Setup
    fun setup() {
        originCollection_100 = createIntList(100)
        originCollection_1_000 = createIntList(1_000)
        originCollection_10_000 = createIntList(10_000)
        originCollection_50_000 = createIntList(50_000)
        originCollection_100_000 = createIntList(100_000)

        memoryConsumer.consumeMemory()
    }

    @Benchmark
    fun filter2_1r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_1r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_2r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_2r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_3r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_3r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_5r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_5r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_10r_10000_rec_sequence(blackHole: Blackhole) {
        filter_sequence_10r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_1r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_1r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_2r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_2r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_3r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_3r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_5r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_5r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun filter2_10r_10000_rec_collection(blackHole: Blackhole) {
        filter_collection_10r(originCollection_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }
}
