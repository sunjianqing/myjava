package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 8/3/17.
 *
 * http://www.cnblogs.com/EdwardLiu/p/4240616.html
 */
public class ReadNCharactersGivenRead4II_158 {


    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buffer = new char[4];
    private int oneRead = 0; // 一次读的
    private int offset = 0; // offset 留着下次读用

    public int read(char[] buf, int n) {
        boolean lessthan4 = false;
        int haveRead = 0;
        while (!lessthan4 && haveRead < n) {
            if (oneRead == 0) {
                oneRead = read4(buffer);
                lessthan4 = oneRead < 4;
            }
            int actRead = Math.min(n-haveRead, oneRead);
            for (int i=0; i<actRead; i++) {
                buf[haveRead+i] = buffer[offset+i];
            }
            oneRead -= actRead;
            offset = (offset + actRead) % 4;
            haveRead += actRead;
        }
        return haveRead;
    }

    private int read4(char[] tmp){
        return 4;
    }
}
