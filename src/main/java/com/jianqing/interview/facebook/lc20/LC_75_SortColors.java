package com.jianqing.interview.facebook.lc20;

/**
 *Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 用双指针来做，分别从原数组的首尾往中心移动。
 *
 * - 定义 red 指针指向开头位置，blue 指针指向末尾位置。
 *
 * - 从头开始遍历原数组，如果遇到0，则交换该值和 red 指针指向的值，并将 red 指针后移一位。
 * 若遇到2，则交换该值和 blue 指针指向的值，并将 blue 指针前移一位。
 * 若遇到1，则继续遍历!!!!
 *
 */
public class LC_75_SortColors {
}
