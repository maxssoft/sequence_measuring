package com.maxssoft.test.sequence2

import com.maxssoft.func.MemoryConsumer
import com.maxssoft.func.createIntList
import com.maxssoft.func.groupBy2_collection_10
import com.maxssoft.func.groupBy2_collection_90
import com.maxssoft.func.groupBy2_sequence_10
import com.maxssoft.func.groupBy2_sequence_90
import com.maxssoft.func.groupBy2_stream_10
import com.maxssoft.func.groupBy2_stream_90
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
class GroupBy2 {

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
    fun groupBy2_90_percentage_100_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_90(originCollection_100).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_1000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_90(originCollection_1_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_90(originCollection_10_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_50000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_90(originCollection_50_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_100000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_90(originCollection_100_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_100_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_90(originCollection_100).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_1000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_90(originCollection_1_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_90(originCollection_10_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_50000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_90(originCollection_50_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_100000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_90(originCollection_100_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_100_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_90(originCollection_100).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_1000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_90(originCollection_1_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_90(originCollection_10_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_50000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_90(originCollection_50_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_90_percentage_100000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_90(originCollection_100_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_100_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_10(originCollection_100).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_1000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_10(originCollection_1_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_10(originCollection_10_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_50000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_10(originCollection_50_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_100000_rec_sequence(blackHole: Blackhole) {
        groupBy2_sequence_10(originCollection_100_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_100_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_10(originCollection_100).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_1000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_10(originCollection_1_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_10(originCollection_10_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_50000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_10(originCollection_50_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_100000_rec_stream(blackHole: Blackhole) {
        groupBy2_stream_10(originCollection_100_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_100_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_10(originCollection_100).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_1000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_10(originCollection_1_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_10(originCollection_10_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_50000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_10(originCollection_50_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun groupBy2_10_percentage_100000_rec_collection(blackHole: Blackhole) {
        groupBy2_collection_10(originCollection_100_000).keys.collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

}
