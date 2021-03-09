package com.example.algorithms.tree

import com.example.algorithms.TreeNode

fun main(args: Array<String>) {
    val root = TreeNode(4)
    val node11 = TreeNode(1)
    val node12 = TreeNode(6)
    val node21 = TreeNode(0)
    val node22 = TreeNode(2)
    val node23 = TreeNode(5)
    val node24 = TreeNode(7)
    val node31 = TreeNode(3)
    val node32 = TreeNode(8)
    root.left = node11
    root.right = node12
    node11.left = node21
    node11.right = node22
    node12.left = node23
    node12.right = node24
    node22.right = node31
    node24.right = node32
    bstToGst(root)
}

fun bstToGst(root: TreeNode?): TreeNode? {
    bstToSortList(root)
    var leftSum = 0
    for (node in list) {
        val tempVal = node.`val`
        node.`val` = sum - leftSum
        leftSum += tempVal
    }
    return root
}

private val list = mutableListOf<TreeNode>()
private var sum = 0

private fun bstToSortList(node: TreeNode?) {
    if (node == null) return
    if (node.left != null) {
        bstToSortList(node.left)
    }
    list.add(node)
    sum += node.`val`
    bstToSortList(node.right)
}
