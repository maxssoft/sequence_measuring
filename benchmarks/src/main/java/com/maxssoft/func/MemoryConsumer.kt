package com.maxssoft.func

import kotlin.math.min

/**
 * Utilize large memory with list of arrays
 *
 * Call [consumeMemory] to create large memory data with size = [RECYCLE_MEMORY_SIZE_MB]
 *
 * @author Max Sidorov on 17.03.2024
 */
class MemoryConsumer {

    companion object {
        private const val RECYCLE_MEMORY_SIZE_MB = 1000

        // don't change this parameters
        private const val LIST_SIZE = 10
        private const val BLOCKS_SIZE = 1024
    }

    private lateinit var memoryDataList: List<MemoryData>

    /**
     * Create list of large objects [MemoryData] and utilize memory size = [memorySizeMb]
     */
    fun consumeMemory(memorySizeMb: Int = RECYCLE_MEMORY_SIZE_MB) {
        val pagesSize = (memorySizeMb * 1024 * 1024) / (LIST_SIZE * BLOCKS_SIZE * Int.SIZE_BYTES)
        val list = ArrayList<MemoryData>(LIST_SIZE)
        for (i in 0..LIST_SIZE) {
            list.add(MemoryData(pagesSize, BLOCKS_SIZE))
        }
        memoryDataList = list
    }

    fun read(): Int = memoryDataList.sumOf { memoryData -> memoryData.readValue() ?: 0 }

    /**
     * Create array [pages] with internal array [blocks]
     */
    private class MemoryData(pagesSize: Int, blocksSize: Int) {
        private val randomIndex = random(min(pagesSize, blocksSize))
        private val pageIndex = randomIndex
        private val pages = Array<Array<Int?>>(pagesSize) {

            val blocks = Array<Int?>(blocksSize) { null }
            blocks[0] = randomIndex
            blocks[randomIndex] = randomIndex

            return@Array blocks
        }

        fun readValue(): Int? {
            val blocks = pages[pageIndex]
            return blocks[blocks[0] ?: 0]
        }
    }
}
