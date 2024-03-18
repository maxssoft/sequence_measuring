package com.maxssoft.test.experiment

import com.maxssoft.func.createIntList
import com.maxssoft.func.map80_collection
import com.maxssoft.func.map80_sequence
import com.maxssoft.func.map20_collection
import com.maxssoft.func.map20_sequence
import com.maxssoft.func.map30_collection
import com.maxssoft.func.map30_sequence
import com.maxssoft.func.map40_collection
import com.maxssoft.func.map40_sequence
import com.maxssoft.func.map50_collection
import com.maxssoft.func.map50_sequence
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
//@Fork(1)
@Fork(value = 1, jvmArgsAppend = [])
// jvmArgsAppend = ["-XX:+UnlockDiagnosticVMOptions","-XX:+PrintAssembly"]
// jvmArgsAppend = ["-XX:-UseOnStackReplacement"]
// jvmArgsAppend = ["-XX:MaxInlineSize=0"]
// jvmArgsAppend = ["-XX:MaxInlineLevel=0"])
@Warmup(iterations = WARN_UP_ITERATIONS, time = WARN_UP_TIME, timeUnit = TimeUnit.SECONDS)
class Map_exp {

    private lateinit var originCollection_1_000: List<Int?>
    private lateinit var originCollection_10_000: List<Int?>
    private lateinit var originCollection_100_000: List<Int?>

    @Setup
    fun setup() {
        originCollection_1_000 = createIntList(1_000)
        originCollection_10_000 = createIntList(10_000)
        originCollection_100_000 = createIntList(100_000)
    }

    @Benchmark
    fun map20_1000_sequence(blackHole: Blackhole) {
        map20_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map20_1000_collection(blackHole: Blackhole) {
        map20_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map30_1000_sequence(blackHole: Blackhole) {
        map30_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map30_1000_collection(blackHole: Blackhole) {
        map30_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map40_1000_sequence(blackHole: Blackhole) {
        map40_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map40_1000_collection(blackHole: Blackhole) {
        map40_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map50_1000_sequence(blackHole: Blackhole) {
        map50_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map50_1000_collection(blackHole: Blackhole) {
        map50_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map80_1000_sequence(blackHole: Blackhole) {
        map80_sequence(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map80_1000_collection(blackHole: Blackhole) {
        map80_collection(originCollection_1_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map20_10000_sequence(blackHole: Blackhole) {
        map20_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map20_10000_collection(blackHole: Blackhole) {
        map20_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map30_10000_sequence(blackHole: Blackhole) {
        map30_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map30_10000_collection(blackHole: Blackhole) {
        map30_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map40_10000_sequence(blackHole: Blackhole) {
        map40_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map40_10000_collection(blackHole: Blackhole) {
        map40_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map50_10000_sequence(blackHole: Blackhole) {
        map50_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map50_10000_collection(blackHole: Blackhole) {
        map50_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map80_10000_sequence(blackHole: Blackhole) {
        map80_sequence(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map80_10000_collection(blackHole: Blackhole) {
        map80_collection(originCollection_10_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map20_100000_sequence(blackHole: Blackhole) {
        map20_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map20_100000_collection(blackHole: Blackhole) {
        map20_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map30_100000_sequence(blackHole: Blackhole) {
        map30_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map30_100000_collection(blackHole: Blackhole) {
        map30_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map40_100000_sequence(blackHole: Blackhole) {
        map40_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map40_100000_collection(blackHole: Blackhole) {
        map40_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map50_100000_sequence(blackHole: Blackhole) {
        map50_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map50_100000_collection(blackHole: Blackhole) {
        map50_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map80_100000_sequence(blackHole: Blackhole) {
        map80_sequence(originCollection_100_000).collectBlackHole(blackHole)
    }

    @Benchmark
    fun map80_100000_collection(blackHole: Blackhole) {
        map80_collection(originCollection_100_000).collectBlackHole(blackHole)
    }

    //@Benchmark
    fun array_copy(blackHole: Blackhole): Int? {
        val array = ArrayList<Int?>(originCollection_10_000.size)
        originCollection_10_000.forEach { value -> array.add(value) }
        return array.last()
    }
}
