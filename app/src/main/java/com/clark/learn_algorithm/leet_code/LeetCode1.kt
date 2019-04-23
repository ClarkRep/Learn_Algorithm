package com.clark.learn_algorithm.leet_code

/**
 * @author clark
 * @description 1、两数之和
 * @date 2019/3/28
 */
fun main() {
//    val intArray: IntArray = intArrayOf(1, 3, 4, 2, 7, 11, 15)
//    val result = twoSum(intArray, 9)
//    print(result[0])
//    print(result[1])

    println(reverse(1000))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map: HashMap<Int, Int> = HashMap()

    for ((index, value) in nums.withIndex()) {
        val div = map.get(target - value)
        if (div != null) {
            return intArrayOf(div, index)
        }
        map.put(value, index)
    }
    return intArrayOf()

}

fun reverse(x: Int): Int {

    var result = 0

    //定义一个临时变量，用来记录每次除于10之后剩余的数。
    var temp = x

    while (temp != 0) {

        val pop = temp % 10
        temp = temp / 10
        if (result > Int.MAX_VALUE / 10 || result < Int.MIN_VALUE / 10 || (result == Int.MAX_VALUE / 10 && pop > Int.MAX_VALUE % 10) || (result == Int.MIN_VALUE / 10 && pop < Int.MIN_VALUE % 10)) {
            return 0
        }
        result = result * 10 + pop
    }
    return result
}

