package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 6/5/17.
 * https://kevinclcn.gitbooks.io/leetcodejava/content/006_zigzag_conversion.html
 *
 * 0           6       12
 * 1        5  7    11
 * 2    4      8  10
 * 3           9
 *
 * 首行和尾行相邻两个元素之间的距离是2*(numRows - 1)
 *
 * 比如 0 和 6 之间 差 2 * ( 4- 1) = 6
 *
 * 首行和尾行之间的其他行除了像首位两行一样有间隔距离2*(numRows - 1)的元素，如，1，7和2，8，
 * 在它们之间还有一个元素，该元素到该行下一个元素的距离为2*i，i为所在行数，所以到上一个元素的距离为2*(numRows -1) - 2*i (比如 2*(4-1) - 2*2 = 2, 所以数字4的位置， 就是数字2往后加2)
 *
 *
 * 找不到上面的规律， 就搞numRows 个StringBuilder
 * 按顺序往里填
 *
 */
public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1 ){
            return s;
        }
        StringBuilder sb = new StringBuilder();


        for (int i = 0 ; i < numRows; i++){
            int index = i;
            while ( index < s.length()){
                sb.append(s.charAt(index));
                index = index + 2*(numRows - 1);

                if(i != 0 && i != numRows -1 ){
                    // not first line and last line
                    int midIndex = index - 2 * i;
                    if( midIndex < s.length()){
                        sb.append(s.charAt(midIndex));
                    }
                }
            }

        }

        return sb.toString();
    }

}
