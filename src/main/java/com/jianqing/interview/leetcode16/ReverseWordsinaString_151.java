package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 6/26/17.
 */
public class ReverseWordsinaString_151 {

    public static void main(String[] args) {
        ReverseWordsinaString_151 rws = new ReverseWordsinaString_151();
        rws.reverseWords("hi!");
    }

    public String reverseWords(String s) {

        String reverseStr = reverseStr(s.trim());
        StringBuilder sb = new StringBuilder();
        String[] splits = reverseStr.split(" ");
        if(splits.length<=1){
            return s.trim();
        }
        sb.append(reverseStr(splits[0]));
        for(int i = 1; i < splits.length; i++){
            if(splits[i].trim().length() >0 ){
                sb.append(" ");
                sb.append(reverseStr(splits[i]));
            }
        }
        return sb.toString();
    }

    private String reverseStr(String s){
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            char c =  arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }

        return new String(arr);
    }
}
