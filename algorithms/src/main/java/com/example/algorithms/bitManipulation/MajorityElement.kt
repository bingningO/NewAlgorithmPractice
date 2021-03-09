package com.example.algorithms.bitManipulation

fun main(args: Array<String>) {
    println(majorityElement(intArrayOf(3,2,3)))
    println(majorityElement(intArrayOf(2,2,1,1,1,2,2)))
}


/**
 * Boyer-Moore Voting Algorithm
 * 这个majority element看作vote 1， 其他数都是vote -1
 * 重点还是这个element一定有n/2以上次出现
 * 所以可以保证如果选错element了途中一定会变成负数，就调整element保证最后count > 0
 */
fun majorityElement(nums: IntArray): Int {
    var count = 0
    var candidate = 0
    for (num in nums) {
        if(count == 0) {
            candidate = num
        }
        count += if(candidate == num) 1 else -1
    }
    return candidate
}

/**
 * 自己的做法：
 * 思想：除了用hashmap 的暴力方法
 * 因为说可以认为一定会存在这个majority element，就想到了先排序，
 * 这个值一定在有序列表的正中间出现
 * ---
 * 另外也可以直接用自带的sort方法
 */
fun majorityElementA(nums: IntArray): Int {
    return quickSort(nums)[nums.size/2]
}

fun quickSort(nums: IntArray): IntArray {
    if (nums.isEmpty() || nums.size == 1)  return nums
    val pivot = nums[0]
    var right = intArrayOf()
    var left = intArrayOf()
    for (i in 1 until nums.size) {
        if(nums[i] < pivot) {
            left += nums[i]
        } else {
            right += nums[i]
        }
    }
    return quickSort(left) + pivot + quickSort(right)
}