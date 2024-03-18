package com.maxssoft.func

/**
 * Utilize large memory with list of arrays
 *
 * @author Max Sidorov on 17.03.2024
 */
class MemoryConsumer {

    companion object {
        private const val ARRAY_COUNT = 1_000_000
        private const val ARRAY_SIZE = 1_000
/*
        private const val ARRAY_COUNT = 10_000
        private const val ARRAY_SIZE = 1_000
*/
    }

    private lateinit var listArrays: List<Array<Int?>>

    fun consumeMemory(arrayCount: Int = ARRAY_COUNT, arraySize: Int = ARRAY_SIZE) {
        val list = mutableListOf<Array<Int?>>()
        for (i in 0..arrayCount) {
            val array = Array<Int?>(arraySize) { null }
            val index = random(arraySize - 1)
            array[0] = index
            array[index] = i
            list.add(array)
        }
        listArrays = list
    }

    fun read(): Int = listArrays.sumOf { array -> array[array[0] ?: 0] ?: 0 }
}
