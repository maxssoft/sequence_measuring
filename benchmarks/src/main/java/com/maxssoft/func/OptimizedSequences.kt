package com.maxssoft.func

/**
 * Fork sequence functions with optimizations
 *
 * distinct, flattent
 *
 * @author Max Sidorov, 18.02.2023
 */

fun <T, K> Sequence<T>.distinctBy_v1(selector: (T) -> K): Sequence<T> {
    return DistinctSequenceV1(this, selector)
}

internal class DistinctSequenceV1<T, K>(private val source: Sequence<T>, private val keySelector: (T) -> K) : Sequence<T> {
    override fun iterator(): Iterator<T> = OptimizedDistinctIterator(source.iterator(), keySelector)
}

// optimization for drop abstract class with call virtual methods and decrease count of read/write operations

private class OptimizedDistinctIterator<T, K>(
    private val source: Iterator<T>, private val keySelector: (T) -> K
) : Iterator<T>{
    private val observed = HashSet<K>()
    // { UNDEFINED_STATE, HAS_NEXT_ITEM, HAS_FINISHED }
    private var nextState: Int = UNDEFINED_STATE
    private var nextItem: T? = null

    override fun hasNext(): Boolean {
        if (nextState == UNDEFINED_STATE)
            calcNext()
        return nextState == HAS_NEXT_ITEM
    }

    override fun next(): T {
        if (nextState == UNDEFINED_STATE)
            calcNext()
        if (nextState == HAS_FINISHED)
            throw NoSuchElementException()
        nextState = UNDEFINED_STATE
        return nextItem as T
    }

    private fun calcNext() {
        while (source.hasNext()) {
            val next = source.next()
            val key = keySelector(next)

            if (observed.add(key)) {
                nextItem = next
                nextState = HAS_NEXT_ITEM // found next item
                return
            }
        }
        nextState = HAS_FINISHED // end of iterator
    }
}

fun <T, K> Sequence<T>.distinctBy_v1_withEnum_when(selector: (T) -> K): Sequence<T> {
    return DistinctSequenceV1_withEnum_When(this, selector)
}

internal class DistinctSequenceV1_withEnum_When<T, K>(private val source: Sequence<T>, private val keySelector: (T) -> K) : Sequence<T> {
    override fun iterator(): Iterator<T> = DistinctIteratorV1_withEnum_When(source.iterator(), keySelector)
}

private class DistinctIteratorV1_withEnum_When<T, K>(
    private val source: Iterator<T>, private val keySelector: (T) -> K
) : Iterator<T>{
    private val observed = HashSet<K>()
    private var nextState: State = State.NotReady
    private var nextItem: T? = null

    override fun hasNext(): Boolean {
        return when (nextState) {
            State.Done -> false
            State.Ready -> true
            else -> calcNext()
        }
    }

    override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        nextState = State.NotReady
        return nextItem as T
    }

    private fun calcNext(): Boolean {
        while (source.hasNext()) {
            val next = source.next()
            val key = keySelector(next)

            if (observed.add(key)) {
                nextItem = next
                nextState = State.Ready // found next item
                return true
            }
        }
        nextState = State.Done // end of iterator
        return false
    }
}

fun <T, K> Sequence<T>.distinctBy_v1_withEnum_condition(selector: (T) -> K): Sequence<T> {
    return DistinctSequenceV1_withEnumCondition(this, selector)
}

internal class DistinctSequenceV1_withEnumCondition<T, K>(private val source: Sequence<T>, private val keySelector: (T) -> K) : Sequence<T> {
    override fun iterator(): Iterator<T> = DistinctIteratorV1_withEnumCondition(source.iterator(), keySelector)
}

// V1 with state by enum
private class DistinctIteratorV1_withEnumCondition<T, K>(
    private val source: Iterator<T>, private val keySelector: (T) -> K
) : Iterator<T>{
    private val observed = HashSet<K>()
    private var nextState = State.NotReady
    private var nextItem: T? = null

    override fun hasNext(): Boolean {
        if (nextState == State.NotReady)
            calcNext()
        return nextState == State.Ready
    }

    override fun next(): T {
        if (nextState == State.NotReady)
            calcNext()
        if (nextState == State.Done)
            throw NoSuchElementException()
        nextState = State.NotReady
        return nextItem as T
    }

    private fun calcNext() {
        while (source.hasNext()) {
            val next = source.next()
            val key = keySelector(next)

            if (observed.add(key)) {
                nextItem = next
                nextState = State.Ready // found next item
                return
            }
        }
        nextState = State.Done // end of iterator
    }
}

fun <T, K> Sequence<T>.distinctBy_v1_withCondition(selector: (T) -> K): Sequence<T> {
    return DistinctSequenceV1_withCondition(this, selector)
}

internal class DistinctSequenceV1_withCondition<T, K>(private val source: Sequence<T>, private val keySelector: (T) -> K) : Sequence<T> {
    override fun iterator(): Iterator<T> = DistinctIteratorV1_withCondition(source.iterator(), keySelector)
}

// V1 with optimized condition
private class DistinctIteratorV1_withCondition<T, K>(
    private val source: Iterator<T>, private val keySelector: (T) -> K
) : Iterator<T>{
    private val observed = HashSet<K>()
    private var nextState: Int = UNDEFINED_STATE
    private var nextItem: T? = null

    override fun hasNext(): Boolean {
        return when(nextState) {
            HAS_NEXT_ITEM -> true
            HAS_FINISHED -> false
            else -> calcNext()
        }
    }

    override fun next(): T {
        when (nextState) {
            UNDEFINED_STATE -> {
                if (!calcNext()) { // if no more items then throw exception
                    throw NoSuchElementException()
                }
            }
            HAS_FINISHED -> {
                throw NoSuchElementException()
            }
            else -> Unit
        }
        nextState = UNDEFINED_STATE
        return nextItem as T
    }

    private fun calcNext(): Boolean {
        while (source.hasNext()) {
            val next = source.next()
            val key = keySelector(next)

            if (observed.add(key)) {
                nextItem = next
                nextState = HAS_NEXT_ITEM // found next item
                return true
            }
        }
        nextState = HAS_FINISHED // end of iterator
        return false
    }
}

fun <T, K> Sequence<T>.distinctBy_withoutAbstractStateInt(selector: (T) -> K): Sequence<T> {
    return DistinctSequenceWithoutAbstractStateInt(this, selector)
}

internal class DistinctSequenceWithoutAbstractStateInt<T, K>(private val source: Sequence<T>, private val keySelector: (T) -> K) : Sequence<T> {
    override fun iterator(): Iterator<T> = DistinctIteratorWithoutAbstractStateInt(source.iterator(), keySelector)
}

// standard implementation without abstract class
private class DistinctIteratorWithoutAbstractStateInt<T, K>(private val source: Iterator<T>, private val keySelector: (T) -> K) : Iterator<T> {
    private var state = UNDEFINED_STATE
    private var nextValue: T? = null
    private val observed = HashSet<K>()

    private fun computeNext() {
        while (source.hasNext()) {
            val next = source.next()
            val key = keySelector(next)

            if (observed.add(key)) {
                setNext(next)
                return
            }
        }

        done()
    }

    override fun hasNext(): Boolean {
        return when (state) {
            HAS_FINISHED -> false
            HAS_NEXT_ITEM -> true
            else -> tryToComputeNext()
        }
    }

    override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        state = UNDEFINED_STATE
        @Suppress("UNCHECKED_CAST")
        return nextValue as T
    }

    private fun tryToComputeNext(): Boolean {
        computeNext()
        return state == HAS_NEXT_ITEM
    }

    /**
     * Sets the next value in the iteration, called from the [computeNext] function
     */
    private fun setNext(value: T): Unit {
        nextValue = value
        state = HAS_NEXT_ITEM
    }

    /**
     * Sets the state to done so that the iteration terminates.
     */
    private fun done() {
        state = HAS_FINISHED
    }
}

fun <T, K> Sequence<T>.distinctBy_withoutAbstract(selector: (T) -> K): Sequence<T> {
    return DistinctSequenceWithoutAbstract(this, selector)
}

internal class DistinctSequenceWithoutAbstract<T, K>(private val source: Sequence<T>, private val keySelector: (T) -> K) : Sequence<T> {
    override fun iterator(): Iterator<T> = DistinctIteratorWithoutAbstract(source.iterator(), keySelector)
}

// standard implementation without abstract class
private class DistinctIteratorWithoutAbstract<T, K>(private val source: Iterator<T>, private val keySelector: (T) -> K) : Iterator<T> {
    private var state = State.NotReady
    private var nextValue: T? = null
    private val observed = HashSet<K>()

    private fun computeNext() {
        while (source.hasNext()) {
            val next = source.next()
            val key = keySelector(next)

            if (observed.add(key)) {
                setNext(next)
                return
            }
        }

        done()
    }

    override fun hasNext(): Boolean {
        return when (state) {
            State.Done -> false
            State.Ready -> true
            else -> tryToComputeNext()
        }
    }

    override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        state = State.NotReady
        @Suppress("UNCHECKED_CAST")
        return nextValue as T
    }

    private fun tryToComputeNext(): Boolean {
        computeNext()
        return state == State.Ready
    }

    /**
     * Sets the next value in the iteration, called from the [computeNext] function
     */
    private fun setNext(value: T): Unit {
        nextValue = value
        state = State.Ready
    }

    /**
     * Sets the state to done so that the iteration terminates.
     */
    private fun done() {
        state = State.Done
    }
}

private enum class State {
    Ready,
    NotReady,
    Done
}

fun <T, K> Sequence<T>.distinctBy_standardStateInt(selector: (T) -> K): Sequence<T> {
    return DistinctSequenceStandardStateInt(this, selector)
}

internal class DistinctSequenceStandardStateInt<T, K>(private val source: Sequence<T>, private val keySelector: (T) -> K) : Sequence<T> {
    override fun iterator(): Iterator<T> = DistinctIteratorStandardStateInt(source.iterator(), keySelector)
}

// standard implementation, enum replaced to int
private class DistinctIteratorStandardStateInt<T, K>(private val source: Iterator<T>, private val keySelector: (T) -> K) : AbstractIteratorStateInt<T>() {
    private val observed = HashSet<K>()

    override fun computeNext() {
        while (source.hasNext()) {
            val next = source.next()
            val key = keySelector(next)

            if (observed.add(key)) {
                setNext(next)
                return
            }
        }

        done()
    }
}

abstract class AbstractIteratorStateInt<T> : Iterator<T> {
    private var state = UNDEFINED_STATE
    private var nextValue: T? = null

    override fun hasNext(): Boolean {
        return when (state) {
            HAS_FINISHED -> false
            HAS_NEXT_ITEM -> true
            else -> tryToComputeNext()
        }
    }

    override fun next(): T {
        if (!hasNext()) throw NoSuchElementException()
        state = UNDEFINED_STATE
        @Suppress("UNCHECKED_CAST")
        return nextValue as T
    }

    private fun tryToComputeNext(): Boolean {
        computeNext()
        return state == HAS_NEXT_ITEM
    }

    /**
     * Computes the next item in the iterator.
     *
     * This callback method should call one of these two methods:
     *
     * * [setNext] with the next value of the iteration
     * * [done] to indicate there are no more elements
     *
     * Failure to call either method will result in the iteration terminating with a failed state
     */
    abstract protected fun computeNext(): Unit

    /**
     * Sets the next value in the iteration, called from the [computeNext] function
     */
    protected fun setNext(value: T): Unit {
        nextValue = value
        state = HAS_NEXT_ITEM
    }

    /**
     * Sets the state to done so that the iteration terminates.
     */
    protected fun done() {
        state = HAS_FINISHED
    }
}
//------------------------------------------------------------------------------------
//---------------------------- F L A T T E N -----------------------------------------
//------------------------------------------------------------------------------------
fun <T> Sequence<Iterable<T>>.flatten_v2(): Sequence<T> = flatten_v2 { it.iterator() }

private fun <T, R> Sequence<T>.flatten_v2(iterator: (T) -> Iterator<R>): Sequence<R> {
    return FlatteningSequence_V2(this, { it }, iterator)
}

// Empty iterator for cause when we haven't next element
private object EmptyIterator: Iterator<Nothing> {
    override fun hasNext(): Boolean = false
    override fun next(): Nothing = throw NoSuchElementException()
}

internal class FlatteningSequence_V2<T, R, E>
constructor(
    private val sequence: Sequence<T>,
    private val transformer: (T) -> R,
    private val iterator: (R) -> Iterator<E>
) : Sequence<E> {

    override fun iterator(): Iterator<E> = object : Iterator<E> {
        private val iterator = sequence.iterator()
        private var itemIterator: Iterator<E> = EmptyIterator // optimization for exclude nullable variable
        private var state: Int = UNDEFINED_STATE // { UNDEFINED_STATE, HAS_NEXT_ITEM, HAS_FINISHED }

        override fun next(): E {
            if (state == UNDEFINED_STATE) { // optimized typical cause hasNext() + next()
                ensureItemIterator()
            }
            state = UNDEFINED_STATE
            return itemIterator.next()
        }

        override fun hasNext(): Boolean {
            return when (state) { // optimized cause for multiple call hasNext()
                HAS_NEXT_ITEM -> true
                HAS_FINISHED -> false
                else -> ensureItemIterator()
            }
        }

        private fun ensureItemIterator(): Boolean {
            if (itemIterator.hasNext()) {
                state = HAS_NEXT_ITEM
                return true
            } else {
                while (iterator.hasNext()) {
                    val nextItemIterator = iterator(transformer(iterator.next()))
                    if (nextItemIterator.hasNext()) {
                        itemIterator = nextItemIterator
                        state = HAS_NEXT_ITEM
                        return true
                    }
                }
                state = HAS_FINISHED
                itemIterator = EmptyIterator
                return false
            }
        }
    }
}

fun <T> Sequence<Iterable<T>>.flatten_standard_withNotNull(): Sequence<T> = flatten_standard_withNotNull { it.iterator() }

private fun <T, R> Sequence<T>.flatten_standard_withNotNull(iterator: (T) -> Iterator<R>): Sequence<R> {
    return FlatteningSequenceStandardWithNotNull(this, { it }, iterator)
}

internal class FlatteningSequenceStandardWithNotNull<T, R, E>
constructor(
    private val sequence: Sequence<T>,
    private val transformer: (T) -> R,
    private val iterator: (R) -> Iterator<E>
) : Sequence<E> {

    override fun iterator(): Iterator<E> = object : Iterator<E> {
        val iterator = sequence.iterator()
        var itemIterator: Iterator<E> = EmptyIterator

        override fun next(): E {
            ensureItemIterator()
            return itemIterator.next()
        }

        override fun hasNext(): Boolean {
            return ensureItemIterator()
        }

        private fun ensureItemIterator(): Boolean {
            if (itemIterator.hasNext()) {
                return true
            }

            while (iterator.hasNext()) {
                val element = iterator.next()
                val nextItemIterator = iterator(transformer(element))
                if (nextItemIterator.hasNext()) {
                    itemIterator = nextItemIterator
                    return true
                }
            }
            itemIterator = EmptyIterator
            return false
        }
    }
}

fun <T> Sequence<Iterable<T>>.flatten_standard_withState(): Sequence<T> = flatten_standard_withState { it.iterator() }

private fun <T, R> Sequence<T>.flatten_standard_withState(iterator: (T) -> Iterator<R>): Sequence<R> {
    return FlatteningSequenceStandardWithState(this, { it }, iterator)
}

internal class FlatteningSequenceStandardWithState<T, R, E>
constructor(
    private val sequence: Sequence<T>,
    private val transformer: (T) -> R,
    private val iterator: (R) -> Iterator<E>
) : Sequence<E> {
    override fun iterator(): Iterator<E> = object : Iterator<E> {
        val iterator = sequence.iterator()
        var itemIterator: Iterator<E>? = null
        private var state: Int = UNDEFINED_STATE

        override fun next(): E {
            if (state == UNDEFINED_STATE) {
                ensureItemIterator()
            }
            if (state == HAS_FINISHED) {
                throw NoSuchElementException()
            }
            state = UNDEFINED_STATE
            return itemIterator!!.next()
        }

        override fun hasNext(): Boolean {
            if (state == UNDEFINED_STATE) {
                ensureItemIterator()
            }
            return state == HAS_NEXT_ITEM
        }

        private fun ensureItemIterator(): Boolean {
            if (itemIterator?.hasNext() == false)
                itemIterator = null

            while (itemIterator == null) {
                if (!iterator.hasNext()) {
                    state = HAS_FINISHED
                    return false
                } else {
                    val element = iterator.next()
                    val nextItemIterator = iterator(transformer(element))
                    if (nextItemIterator.hasNext()) {
                        itemIterator = nextItemIterator
                        state = HAS_NEXT_ITEM
                        return true
                    }
                }
            }
            state = HAS_NEXT_ITEM
            return true
        }
    }
}



private const val UNDEFINED_STATE = -1 // next item undefined
private const val HAS_NEXT_ITEM = 0 // has next item
private const val HAS_FINISHED = 1 // has finished iteration



