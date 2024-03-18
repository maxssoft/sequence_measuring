package com.maxssoft.test.sequence2

import com.maxssoft.func.MemoryConsumer
import com.maxssoft.func.createIntList
import com.maxssoft.func.distinct2_collection_10
import com.maxssoft.func.distinct2_collection_90
import com.maxssoft.func.distinct2_sequence_10
import com.maxssoft.func.distinct2_sequence_10_optimized
import com.maxssoft.func.distinct2_sequence_90
import com.maxssoft.func.distinct2_sequence_90_optimized
import com.maxssoft.func.distinct2_stream_10
import com.maxssoft.func.distinct2_stream_90
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

@State(Scope.Benchmark) // Scope.Benchmark
@Fork(1)
@Warmup(iterations = WARN_UP_ITERATIONS, time = WARN_UP_TIME, timeUnit = TimeUnit.SECONDS)
class Distinct2 {

    private lateinit var originCollection90_100: List<Int?>
    private lateinit var originCollection90_1_000: List<Int?>
    private lateinit var originCollection90_10_000: List<Int?>
    private lateinit var originCollection90_50_000: List<Int?>
    private lateinit var originCollection90_100_000: List<Int?>

    private lateinit var originCollection10_100: List<Int?>
    private lateinit var originCollection10_1_000: List<Int?>
    private lateinit var originCollection10_10_000: List<Int?>
    private lateinit var originCollection10_50_000: List<Int?>
    private lateinit var originCollection10_100_000: List<Int?>

    private val memoryConsumer = MemoryConsumer()

    @Setup
    fun setup() {
        originCollection90_100 = createIntList(100).map { it?.let { it * 90 / 100 }  }
        originCollection90_1_000 = createIntList(1_000).map { it?.let { it * 90 / 100 }  }
        originCollection90_10_000 = createIntList(10_000).map { it?.let { it * 90 / 100 }  }
        originCollection90_50_000 = createIntList(50_000).map { it?.let { it * 90 / 100 }  }
        originCollection90_100_000 = createIntList(100_000).map { it?.let { it * 90 / 100 }  }

        originCollection10_100 = createIntList(100).map { it?.let { it * 10 / 100 }  }
        originCollection10_1_000 = createIntList(1_000).map { it?.let { it * 10 / 100 }  }
        originCollection10_10_000 = createIntList(10_000).map { it?.let { it * 10 / 100 }  }
        originCollection10_50_000 = createIntList(50_000).map { it?.let { it * 10 / 100 }  }
        originCollection10_100_000 = createIntList(100_000).map { it?.let { it * 10 / 100 }  }

        memoryConsumer.consumeMemory()
    }

    @Benchmark
    fun distinct2_90_percentage_100_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_90(originCollection90_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_1000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_90(originCollection90_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_10000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_90(originCollection90_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_50000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_90(originCollection90_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_100000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_90(originCollection90_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_100_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_90_optimized(originCollection90_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_1000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_90_optimized(originCollection90_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_10000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_90_optimized(originCollection90_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_50000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_90_optimized(originCollection90_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_100000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_90_optimized(originCollection90_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_100_rec_collection(blackHole: Blackhole) {
        distinct2_collection_90(originCollection90_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_1000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_90(originCollection90_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_10000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_90(originCollection90_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_50000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_90(originCollection90_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_100000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_90(originCollection90_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_100_rec_stream(blackHole: Blackhole) {
        distinct2_stream_90(originCollection90_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_1000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_90(originCollection90_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_10000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_90(originCollection90_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_50000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_90(originCollection90_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_90_percentage_100000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_90(originCollection90_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_10(originCollection10_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_1000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_10(originCollection10_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun distinct2_10_percentage_10000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_10(originCollection10_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_50000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_10(originCollection10_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100000_rec_sequence(blackHole: Blackhole) {
        distinct2_sequence_10(originCollection10_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_10_optimized(originCollection10_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_1000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_10_optimized(originCollection10_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_10000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_10_optimized(originCollection10_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_50000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_10_optimized(originCollection10_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100000_rec_sequence_opt(blackHole: Blackhole) {
        distinct2_sequence_10_optimized(originCollection10_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100_rec_collection(blackHole: Blackhole) {
        distinct2_collection_10(originCollection10_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_1000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_10(originCollection10_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_10000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_10(originCollection10_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_50000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_10(originCollection10_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100000_rec_collection(blackHole: Blackhole) {
        distinct2_collection_10(originCollection10_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100_rec_stream(blackHole: Blackhole) {
        distinct2_stream_10(originCollection10_100).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_1000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_10(originCollection10_1_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_10000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_10(originCollection10_10_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_50000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_10(originCollection10_50_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

    @Benchmark
    fun distinct2_10_percentage_100000_rec_stream(blackHole: Blackhole) {
        distinct2_stream_10(originCollection10_100_000).collectBlackHole(blackHole)
        blackHole.consume(memoryConsumer.read())
    }

}
