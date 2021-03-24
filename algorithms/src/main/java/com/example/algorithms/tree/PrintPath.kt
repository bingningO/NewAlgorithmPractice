package com.example.algorithms.tree

import java.util.*

fun main() {
    val input = listOf(
        "/abc/app/aaaaa",
        "/abc/app/bbbbb",
        "/doc/aaaaa",
        "/abc/app/a",
        "/app/a"
    )
    printPath(input)
//    printPath(listOf(""))
//    printPath(listOf("///", "/app/a", "/app//a"))
}

private fun printPath(paths: List<String>) {
    // 1. get tree
    val tree = TreeMap<String, Int>()
    paths.forEach { path ->
        var layerCount = 0
        path.forEachIndexed { index, c ->
            if (c == '/') {
                tree[path.substring(0, index)] = layerCount
                layerCount++
            }
        }
        tree[path] = layerCount
    }
    // 2. print
    tree.forEach { (str, index) ->
        if(str.isNotBlank()) {
            (0 until index).forEach { _ ->
                print('-')
            }
            println(str.split('/').last())
        }
    }
}