package com.example.algorithms

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

object Util {
    fun <T>printList(list: List<T>) {
        list.forEach {
            print("$it ")
        }
        println()
    }
}