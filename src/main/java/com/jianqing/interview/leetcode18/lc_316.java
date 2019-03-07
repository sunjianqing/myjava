package com.jianqing.interview.leetcode18;

/**
 * Remove Duplicate Letters
 *
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 *
 * Input: bcdbac
 * Output: bcda 不是cdba, 也不是dbac
 *
 * 先找到各个字母最后一次出现的位置， 找到这些位置离最小的index，那个字符有可能需要保留， 因为之后再也没有它了， 然后从那个index往前搜
 * 找到最小的字符，就是当前需要放进结果集的, 接着重复上面找最小index 的步骤， 再找下一个候选字符
 *
 * bcdbac
 * a:4
 * c:5
 * b:3
 * d:2
 *
 * d 的index 最小， 从 0-2找找有没有比d 小的， 有，b, 就把b 放进结果,记录一指针p = 0
 * 然后看a,c,d ， 发现d 的index 最小, 再从p+1跟d 的index 之间找最小的，发现c, 然后 p=1
 * 再看a,d , 发现d的index 最小， 再从p + 1 跟d 的index 之间找最小的， 发现d, 然后 p=2
 * 最后剩a ， 就得到了 bcda
 */
public class lc_316 {


}
