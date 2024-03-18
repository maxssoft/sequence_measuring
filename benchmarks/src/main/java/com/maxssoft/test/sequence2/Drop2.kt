package com.maxssoft.test.sequence2

import com.maxssoft.func.MemoryConsumer
import com.maxssoft.func.createIntList
import com.maxssoft.func.filter_collection_10
import com.maxssoft.func.filter_collection_90
import com.maxssoft.func.drop2_collection
import com.maxssoft.func.drop2_sequence
import com.maxssoft.func.drop2_stream
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
class Drop2 {

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
        //println("filter_collection_90 = 1.000 -> ${filter_collection_90(originCollection_1_000).size}")
        //println("filter_collection_10 = 1.000 -> ${filter_collection_10(originCollection_1_000).size}")
    }

    @Benchmark
    fun drop2_90_percentage_100_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_100, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_1000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_1_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_10_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_50000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_50_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_100000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_100_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_100_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_100, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_1000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_1_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_10_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_50000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_50_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_100000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_100_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_100_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_100, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_1000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_1_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_10_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_50000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_50_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_90_percentage_100000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_100_000, 90).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    // ---------
    @Benchmark
    fun drop2_10_percentage_100_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_100, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_1000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_1_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_10_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_50000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_50_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_100000_rec_sequence(blackHole: Blackhole) {
        drop2_sequence(originCollection_100_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_100_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_100, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_1000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_1_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_10_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_50000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_50_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_100000_rec_stream(blackHole: Blackhole) {
        drop2_stream(originCollection_100_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_100_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_100, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_1000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_1_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_10_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_50000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_50_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun drop2_10_percentage_100000_rec_collection(blackHole: Blackhole) {
        drop2_collection(originCollection_100_000, 10).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }
}
