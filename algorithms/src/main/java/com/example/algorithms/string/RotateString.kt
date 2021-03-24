package com.example.algorithms.string

fun main() {
    println(rotateString("abcde", "cdeab"))
    println(rotateString("abcde", "cdebc"))
}

/**
 * 就是考虑他们的组成是XY，YX
 * 找到X和Y的分界index
 * 可以从A的头部和B的尾部开始，用一个window来找他们的相同部分
 */
fun rotateString(A: String, B: String): Boolean {
    if(A.length != B.length) return  false
    if (A.isBlank()) return true
    var windowLen = 1
    while (windowLen< A.length) {
        if (A.subSequence(0, windowLen)  == B.subSequence(B.length - windowLen - 1, B.length -1) && A.subSequence(windowLen+1, A.length -1) == B.subSequence(0, B.length - windowLen - 2) ) {
           return true
        }
        windowLen++
    }
    return false
}

fun rotateString1(A: String, B: String): Boolean {
    if(A.length != B.length) return  false
    if (A.isBlank()) return true
    var newA = A.substring(1) + A[0]
    var rotateCount = 1
    while (rotateCount < A.length) {
        if (newA == B)  return true
        newA = newA.substring(1) + newA[0]
        rotateCount++
    }
    return false
}
