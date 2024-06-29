package com.maxssoft.test.exclude.sequence2.calculated

import com.maxssoft.func.MemoryConsumer
import com.maxssoft.func.createIntList
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
class Map_consume {

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
    fun map_consume_100_rec_sequence(blackHole: Blackhole) {
        originCollection_100.asSequence().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_1000_rec_sequence(blackHole: Blackhole) {
        originCollection_1_000.asSequence().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_10000_rec_sequence(blackHole: Blackhole) {
        originCollection_10_000.asSequence().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_50000_rec_sequence(blackHole: Blackhole) {
        originCollection_50_000.asSequence().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_100000_rec_sequence(blackHole: Blackhole) {
        originCollection_100_000.asSequence().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_100_rec_collection(blackHole: Blackhole) {
        originCollection_100.collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_1000_rec_collection(blackHole: Blackhole) {
        originCollection_1_000.collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_10000_rec_collection(blackHole: Blackhole) {
        originCollection_10_000.collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_50000_rec_collection(blackHole: Blackhole) {
        originCollection_50_000.collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_100000_rec_collection(blackHole: Blackhole) {
        originCollection_100_000.collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_100_rec_stream(blackHole: Blackhole) {
        originCollection_100.stream().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_1000_rec_stream(blackHole: Blackhole) {
        originCollection_1_000.stream().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_10000_rec_stream(blackHole: Blackhole) {
        originCollection_10_000.stream().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_50000_rec_stream(blackHole: Blackhole) {
        originCollection_50_000.stream().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun map_consume_100000_rec_stream(blackHole: Blackhole) {
        originCollection_100_000.stream().collectSum(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

}
