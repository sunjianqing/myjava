package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqingsun on 12/7/16.
 */
public class ReverseVowelsofaString_345 implements Solution{
    @Override
    public void solution() {

    }

    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a','e','i','o','u');

        if(s.length() == 0) return s;

        int i = 0, j = s.length()-1;
        char[] chars = s.toCharArray();

        while (i < j){
            if (vowels.contains(chars[i])){
                while(!vowels.contains(chars[j])){
                    j--;
                    if(j<0)
                        break;
                }
                if(j > i){
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }


            if (vowels.contains(chars[j])){
                while(!vowels.contains(chars[i])){
                    i++;
                    if(i>=s.length())
                        break;
                }
                if(j > i){
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
            i++;
            j--;

        }

        return String.valueOf(chars);
    }

    public String reverseVowels2(String s) {
    ArrayList<Character> vowList = new ArrayList<Character>();
    vowList.add('a');
    vowList.add('e');
    vowList.add('i');
    vowList.add('o');
    vowList.add('u');
    vowList.add('A');
    vowList.add('E');
    vowList.add('I');
    vowList.add('O');
    vowList.add('U');

    char[] arr = s.toCharArray();

    int i=0;
    int j=s.length()-1;

    while(i<j){
        if(!vowList.contains(arr[i])){
            i++;
            continue;
        }

        if(!vowList.contains(arr[j])){
            j--;
            continue;
        }

        char t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;

        i++;
        j--;
    }

    return new String(arr);
    }
}
