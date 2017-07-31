package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 7/15/17.
 */
public class ExcelSheetColumnTitle_168 {

    public static void main(String[] args) {
        ExcelSheetColumnTitle_168 ex = new ExcelSheetColumnTitle_168();
        System.out.println((ex.convertToTitle(27)));
    }
    public String convertToTitle(int n) {
        Map<Integer, Character> map = new HashMap<>();

        char c = 'A';
        for ( int i = 1 ; i <= 26 ; i++){
            map.put(i, c);
            c = (char)(c + 1 );
        }

        if(n <= 26){
            return String.valueOf(map.get(n));
        }

        StringBuilder sb = new StringBuilder();

        while( n > 0) {

            int index = n % 26 == 0 ? 26 : n % 26;
            sb.insert(0, map.get(index));

            n = (n - 1) / 26;

        }

        return sb.toString();
    }

    public String convertToTitle2(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
