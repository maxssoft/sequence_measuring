package com.maxssoft.test.r_un4

import com.maxssoft.func.MemoryConsumer
import com.maxssoft.func.createIntList
import com.maxssoft.func.minus2_collection
import com.maxssoft.func.minus2_sequence
import com.maxssoft.func.minus2_stream
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
class Minus2 {

    private lateinit var originCollection_100: List<Int?>
    private lateinit var originCollection_10_perc_100: Set<Int?>
    private lateinit var originCollection_90_perc_100: Set<Int?>
    private lateinit var originCollection_1_000: List<Int?>
    private lateinit var originCollection_10_perc_1_000: Set<Int?>
    private lateinit var originCollection_90_perc_1_000: Set<Int?>
    private lateinit var originCollection_10_000: List<Int?>
    private lateinit var originCollection_10_perc_10_000: Set<Int?>
    private lateinit var originCollection_90_perc_10_000: Set<Int?>
    private lateinit var originCollection_50_000: List<Int?>
    private lateinit var originCollection_10_perc_50_000: Set<Int?>
    private lateinit var originCollection_90_perc_50_000: Set<Int?>
    private lateinit var originCollection_100_000: List<Int?>
    private lateinit var originCollection_10_perc_100_000: Set<Int?>
    private lateinit var originCollection_90_perc_100_000: Set<Int?>

    private val memoryConsumer = MemoryConsumer()

    @Setup
    fun setup() {
        originCollection_100 = createIntList(100)
        originCollection_10_perc_100 = createIntList(10).toSet()
        originCollection_90_perc_100 = createIntList(90).toSet()
        originCollection_1_000 = createIntList(1_000)
        originCollection_10_perc_1_000 = createIntList(100).toSet()
        originCollection_90_perc_1_000 = createIntList(900).toSet()
        originCollection_10_000 = createIntList(10_000)
        originCollection_10_perc_10_000 = createIntList(1_000).toSet()
        originCollection_90_perc_10_000 = createIntList(9_000).toSet()
        originCollection_50_000 = createIntList(50_000)
        originCollection_10_perc_50_000 = createIntList(5_000).toSet()
        originCollection_90_perc_50_000 = createIntList(45_000).toSet()
        originCollection_100_000 = createIntList(100_000)
        originCollection_10_perc_100_000 = createIntList(10_000).toSet()
        originCollection_90_perc_100_000 = createIntList(90_000).toSet()

        memoryConsumer.consumeMemory()
    }

    @Benchmark
    fun minus2_90_percentage_100_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_100, originCollection_90_perc_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_1000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_1_000, originCollection_90_perc_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_10_000, originCollection_90_perc_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_50000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_50_000, originCollection_90_perc_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_100000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_100_000, originCollection_90_perc_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_100_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_100, originCollection_90_perc_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_1000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_1_000, originCollection_90_perc_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_10_000, originCollection_90_perc_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_50000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_50_000, originCollection_90_perc_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_100000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_100_000, originCollection_90_perc_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_100_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_100, originCollection_90_perc_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_1000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_1_000, originCollection_90_perc_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_10_000, originCollection_90_perc_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_50000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_50_000, originCollection_90_perc_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_90_percentage_100000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_100_000, originCollection_90_perc_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_100_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_100, originCollection_10_perc_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_1000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_1_000, originCollection_10_perc_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_10_000, originCollection_10_perc_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_50000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_50_000, originCollection_10_perc_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_100000_rec_sequence(blackHole: Blackhole) {
        minus2_sequence(originCollection_100_000, originCollection_10_perc_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_100_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_100, originCollection_10_perc_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_1000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_1_000, originCollection_10_perc_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_10_000, originCollection_10_perc_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_50000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_50_000, originCollection_10_perc_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_100000_rec_stream(blackHole: Blackhole) {
        minus2_stream(originCollection_100_000, originCollection_10_perc_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_100_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_100, originCollection_10_perc_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_1000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_1_000, originCollection_10_perc_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_10_000, originCollection_10_perc_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_50000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_50_000, originCollection_10_perc_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun minus2_10_percentage_100000_rec_collection(blackHole: Blackhole) {
        minus2_collection(originCollection_100_000, originCollection_10_perc_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }
}
