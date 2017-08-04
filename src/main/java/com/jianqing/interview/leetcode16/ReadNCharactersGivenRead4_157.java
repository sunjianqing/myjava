package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 6/28/17.
 * http://blog.csdn.net/fantasiasango/article/details/52669281
 *
 *
 */
public class ReadNCharactersGivenRead4_157 {
    //读 n 个 到 buf 里
    public int read(char[] buf, int n){
        int total = 0;
        boolean eof = false;
        while( !eof && total < n){
            char[] mybuf = new char[4];
            int cnt = read4(mybuf);

            eof = cnt < 4;
            cnt = Math.min(cnt, n - total);

            for(int i = 0 ; i < cnt ; i++){
                buf[total++] = mybuf[i];
            }
        }

        return total;
    }

    private int read4(char[] tmp){
        return 4;
    }


}
