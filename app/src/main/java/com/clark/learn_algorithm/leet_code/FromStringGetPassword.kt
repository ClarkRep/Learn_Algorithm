package com.clark.learn_algorithm.leet_code

import java.util.*

/**
 * @author
 * @description
 * 问题描述：假设字符串中的所有字符不重复，从字符串中选取任意字符，组合成n位的新字符串，输出所有可能的组合字符串
 * 例如，输入字符串为“abc”，输出2位，则输出ab、ba、ac、ca、bc、cb，共6种组合。
 * 输入：
 * 不包含重复字符的字符串 ：str
 * 新的组合字符串的长度  ：  n
 * @date 2019/4/1
 */

fun main() {
    val str = "abcdefg"

    val charList: LinkedList<Char> = LinkedList()
    for (char in str) {
        charList.add(char)
    }

    val sb = java.lang.StringBuilder()
    printPSW(sb, charList, 3)

}

fun printPSW(sb: java.lang.StringBuilder, charList: LinkedList<Char>, n: Int) {
    if (sb.length == n) {
        println(sb)
    } else {
        for ((index, char) in charList.withIndex()) {
            val removeAt = charList.removeAt(index)
            sb.append(removeAt)
            printPSW(sb, charList, n)
            charList.add(index, removeAt)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}
