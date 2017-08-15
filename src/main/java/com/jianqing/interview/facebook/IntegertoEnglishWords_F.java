package com.jianqing.interview.facebook;

/**
 * Created by jianqingsun on 8/8/17.
 */
public class IntegertoEnglishWords_F {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";

        String words = "";
        int i = 0;

        while(num > 0) {

            if(num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int n) {

        if(n == 0){
            return "";
        }
        else if( n < 20) {
            return LESS_THAN_20[n % 20];
        }
        else if( n < 100) {
            return TENS[ n / 100 ] + " " + helper( n % 10);
        }
        else {
            return LESS_THAN_20[ n / 100] + " Hundred " + helper( n % 100 );
        }

    }

}
