package com.jianqing.interview.facebook.lc20;


/**
 * read() function 可能会被call 多次， 就是说这次可能要 n = 3, 下次可能要 n = 1
 * https://youtu.be/w3ke3MQTEJ8
 *
 */
public class LC_158_Read4II {

    // 需要几个全局变量
    private char[] tmp = new char[4];
    private int lastPointer = 0; // 上次剩的
    private int curReadCnt = 0;

    /**
     * @param buf
     * @param n
     * @return the number of actual characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (lastPointer == 0) {
                curReadCnt = read4(tmp);
            }

            if (curReadCnt == 0) { // 整个文件读完了
                break;
            }

            // 把读到的赋给buf， 剩下的留在tmp里，下次用！
            while (index < n && lastPointer < curReadCnt) {
                buf[index] = tmp[lastPointer];
                index++;
                lastPointer++;
            }

            if (lastPointer >= curReadCnt) {
                lastPointer = 0;
            }
        }
        return index;
    }

    // mock func
    public int read4(char[] buf) {
        return 4;
    }

}
