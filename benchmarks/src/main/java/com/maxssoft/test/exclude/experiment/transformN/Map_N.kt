package com.maxssoft.test.exclude.experiment.transformN

import com.maxssoft.func.createIntList
import com.maxssoft.func.map10_collection
import com.maxssoft.func.map10_sequence
import com.maxssoft.func.map10_stream
import com.maxssoft.func.map1_collection
import com.maxssoft.func.map1_sequence
import com.maxssoft.func.map1_stream
import com.maxssoft.func.map80_collection
import com.maxssoft.func.map80_sequence
import com.maxssoft.func.map20_collection
import com.maxssoft.func.map20_sequence
import com.maxssoft.func.map20_stream
import com.maxssoft.func.map2_collection
import com.maxssoft.func.map2_sequence
import com.maxssoft.func.map2_stream
import com.maxssoft.func.map30_collection
import com.maxssoft.func.map30_sequence
import com.maxssoft.func.map30_stream
import com.maxssoft.func.map3_collection
import com.maxssoft.func.map3_sequence
import com.maxssoft.func.map3_stream
import com.maxssoft.func.map40_collection
import com.maxssoft.func.map40_sequence
import com.maxssoft.func.map40_stream
import com.maxssoft.func.map50_collection
import com.maxssoft.func.map50_sequence
import com.maxssoft.func.map50_stream
import com.maxssoft.func.map5_collection
import com.maxssoft.func.map5_sequence
import com.maxssoft.func.map5_stream
import com.maxssoft.func.map80_stream
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
//@Fork(1)
@Fork(value = 1, jvmArgsAppend = [])
// jvmArgsAppend = ["-XX:+UnlockDiagnosticVMOptions","-XX:+PrintAssembly"]
// jvmArgsAppend = ["-XX:-UseOnStackReplacement"]
// jvmArgsAppend = ["-XX:MaxInlineSize=0"]
// jvmArgsAppend = ["-XX:MaxInlineLevel=0"])
@Warmup(iterations = WARN_UP_ITERATIONS, time = WARN_UP_TIME, timeUnit = TimeUnit.SECONDS)
class Map_N {

    private lateinit var originCollection: List<Int?>

    @Setup
    fun setup() {
        originCollection = createIntList(10_000)
    }

    @Benchmark
    fun map1_10000_sequence(blackHole: Blackhole) {
        map1_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map1_10000_collection(blackHole: Blackhole) {
        map1_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map1_10000_stream(blackHole: Blackhole) {
        map1_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map2_10000_sequence(blackHole: Blackhole) {
        map2_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map2_10000_collection(blackHole: Blackhole) {
        map2_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map2_10000_stream(blackHole: Blackhole) {
        map2_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map3_10000_sequence(blackHole: Blackhole) {
        map3_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map3_10000_collection(blackHole: Blackhole) {
        map3_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map3_10000_stream(blackHole: Blackhole) {
        map3_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map5_10000_sequence(blackHole: Blackhole) {
        map5_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map5_10000_collection(blackHole: Blackhole) {
        map5_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map5_10000_stream(blackHole: Blackhole) {
        map5_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map10_10000_sequence(blackHole: Blackhole) {
        map10_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map10_10000_collection(blackHole: Blackhole) {
        map10_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map10_10000_stream(blackHole: Blackhole) {
        map10_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map20_10000_sequence(blackHole: Blackhole) {
        map20_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map20_10000_collection(blackHole: Blackhole) {
        map20_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map20_10000_stream(blackHole: Blackhole) {
        map20_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map30_10000_sequence(blackHole: Blackhole) {
        map30_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map30_10000_collection(blackHole: Blackhole) {
        map30_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map30_10000_stream(blackHole: Blackhole) {
        map30_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map40_10000_sequence(blackHole: Blackhole) {
        map40_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map40_10000_collection(blackHole: Blackhole) {
        map40_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map40_10000_stream(blackHole: Blackhole) {
        map40_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map50_10000_sequence(blackHole: Blackhole) {
        map50_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map50_10000_collection(blackHole: Blackhole) {
        map50_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map50_10000_stream(blackHole: Blackhole) {
        map50_stream(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map80_10000_sequence(blackHole: Blackhole) {
        map80_sequence(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map80_10000_collection(blackHole: Blackhole) {
        map80_collection(originCollection).collectSum(blackHole)
    }

    @Benchmark
    fun map80_10000_stream(blackHole: Blackhole) {
        map80_stream(originCollection).collectSum(blackHole)
    }
}
