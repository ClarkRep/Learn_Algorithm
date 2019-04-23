package com.clark.learn_algorithm.leet_code;

/**
 * @author
 * @description
 * @date 2019/4/3
 */
public class Test {

    public static void main(String[] args) {
        int result = (((0XF0FF & 0X000F) | 0X00F0) << 1) / (4 >> 1);
        System.out.println(result);
    }
}
