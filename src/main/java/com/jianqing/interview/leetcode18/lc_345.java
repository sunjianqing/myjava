package com.jianqing.interview.leetcode18;

public class lc_345 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (isVowels(i, chars)) {
                while (j >= 0) {
                    if (isVowels(j, chars)) {
                        swap(i, j, chars);
                        j--;
                        i++;
                        break;
                    } else {
                        j--;
                    }
                }

            }
            else{
                i++;
            }
        }

        return String.valueOf(chars);
    }

    public void swap(int i, int j, char[] chars){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public boolean isVowels(int i, char[] chars){
      return  chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'
         || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U'
                ;

    }

}
