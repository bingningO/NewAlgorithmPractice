package com.example.algorithms.list

import com.example.algorithms.Util
import java.util.*

fun main() {
    val list = LinkedList<Int>()
    list.add(0)
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    val evenList = LinkedList<Int>()
    val oddList = LinkedList<Int>()
    separateLinkedList(list, evenList, oddList)
    Util.printList(evenList)
    Util.printList(oddList)
}

private fun separateLinkedList(list: LinkedList<Int>, evenList: LinkedList<Int>, oddReverseList: LinkedList<Int>) {
    list.forEachIndexed { index, i ->
        if (index%2 == 0) {
            evenList.addLast(i)
        } else {
            oddReverseList.addFirst(i)
        }
    }
}