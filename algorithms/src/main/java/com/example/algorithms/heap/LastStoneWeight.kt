package com.example.algorithms.heap

import java.util.*

fun main() {
    print(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
}

/**
 * 记住heap是个max/min-priority queue
 *
 */
fun lastStoneWeight(stones: IntArray): Int {
    val heap = PriorityQueue<Int>(reverseOrder())
    stones.forEach {
        heap.add(it)
    }
    while (heap.size > 1) {
        val a = heap.remove()
        val b = heap.remove()
        val newStone = a - b
        if (newStone > 0) heap.add(newStone)
    }
    return if (heap.isEmpty()) 0 else heap.remove()
}