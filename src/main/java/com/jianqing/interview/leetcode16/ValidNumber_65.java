package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/12/17.
 * <p>
 * 2.183x103 - 1.1x10-2
 * = 2.183E3 - 1.1E-2
 * = 2182.989
 */
public class ValidNumber_65 {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {

            if(Character.isDigit(s.charAt(i))){ // 0 - 9
                numSeen = true;
                numberAfterE = true;
            }
            else if(s.charAt(i) == '.'){
                if(eSeen || pointSeen){ // 小数点前面不能看见e， 后面不能再出现小数点
                    return false;
                }

                pointSeen = true;
            }
            else if(s.charAt(i) == 'e'){
                if(eSeen || !numSeen){ // e 曾经出现， 或者数字以前没出现过， 都不合法
                    return false;
                }

                numberAfterE = false; // e 出现了， 后面必须得有数字， 所以这里初始化numbeAfterE为负数
                eSeen = true;
            }
            else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i-1) != 'e'){ // '-' 跟 '+' 可以出现在句中，但是前面一个字符必须是e
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return numSeen && numberAfterE;
    }
}
