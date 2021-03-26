package com.example.algorithms.tree

import com.example.algorithms.TreeNode

fun main() {
    val root = TreeNode(2)
    val node11 = TreeNode(4)
    val node12 = TreeNode(-6)
    val node21 = TreeNode(1)
    val node22 = TreeNode(4)
    val node23 = TreeNode(5)
    val node31 = TreeNode(2)
    val node32 = TreeNode(2)
    root.left = node11
    root.right = node12
    node11.right = node21
    node12.left = node22
    node12.right = node23
    node21.left = node31
    node21.right = node32
    println(countPathNum(root, 7))
    println(countPathNum(root, 1))
    println(countPathNum(root, 0))
    println(countPathNum(root, 9))
}

/**
 * tree is binary tree
 * count the num of paths whose sum is same as a given value
 * the path don't need to start from root or end at leaf
 *
 * thoughts:
 * using hashmap (node, list of all paths sum)
 * root's sum list = (left.each + root.val) + (right.each + root.val)
 */
private fun countPathNum(root: TreeNode, sum: Int): Int {
    val sumMap = HashMap<TreeNode, List<Int>>()
    countPathSumToMap(root, sumMap)
    var count = 0
    sumMap.forEach { (node, list) ->
        count += list.filter { it == sum }.size
    }
    return count
}

private fun countPathSumToMap(node: TreeNode?, map: HashMap<TreeNode, List<Int>>) {
    if (node == null) return
    countPathSumToMap(node.left, map)
    countPathSumToMap(node.right, map)
    val leftArraySum = map[node.left]?.map { it + node.`val` } ?: emptyList()
    val rightArraySum = map[node.right]?.map { it + node.`val` } ?: emptyList()
    val nodeSumList = mutableListOf<Int>()
    nodeSumList.addAll(leftArraySum)
    nodeSumList.addAll(rightArraySum)
    nodeSumList.add(node.`val`)
    map[node] = nodeSumList
}