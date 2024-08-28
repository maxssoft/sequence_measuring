package com.maxssoft.test.exclude.experiment.large

import com.maxssoft.test.factory.WARN_UP_ITERATIONS
import com.maxssoft.test.factory.WARN_UP_TIME
import com.maxssoft.test.factory.large.AppWidget
import com.maxssoft.test.factory.large.BackdropInfo
import com.maxssoft.test.factory.large.WidgetDataFactory
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
class MaxInlineSize {

    private lateinit var widgets: List<AppWidget>
    private lateinit var favorites: Set<AppWidget>
    private lateinit var backdropCriteria: BackdropInfo

    @Setup
    fun setup() {
        val factory = WidgetDataFactory()
        backdropCriteria = factory.backdropInfo()
        widgets = buildList {
            repeat(1000) {
                add(factory.widget())
            }
        }
        favorites = buildSet {
            repeat(10) {
                add(factory.widget())
            }
        }
    }

    @Benchmark
    fun transformation(blackHole: Blackhole) {
        widgets
            .filter { favorites.contains(it) }
            .map { Pair(it.packageName, it.backdropInfo) }
            .filter { it.second == backdropCriteria }
            .sortedBy { it.first }
    }
}
