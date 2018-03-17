package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 11/13/17.
 *
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.

 * <p>
 * 1. 首先要能判断多少个word组成一行：
 * 这里统计读入的所有words的总长curLen，并需要计算空格的长度。假如已经读入words[0:i]。当curLen + i <=L 且加curLen + 1 + word[i+1].size() > L时，一行结束。
 * <p>
 * 2. 知道一行的所有n个words，以及总长curLen之后要决定空格分配：
 * 平均空格数：k = (L - curLen) / (n-1)
 * 前m组每组有空格数k+1：m = (L - curLen) % (n-1)
 * <p>
 * 例子：L = 21，curLen = 14，n = 4
 * k = (21 - 14) / (4-1) = 2
 * m = (21 - 14) % (4-1)  = 1
 * A---B--C--D
 * <p>
 * 3. 特殊情况：
 * (a) 最后一行：当读入到第i = words.size()-1 个word时为最后一行。该行k = 1，m = 0
 * (b) 一行只有一个word：此时n-1 = 0，计算(L - curLen)/(n-1)会出错。该行k = L-curLen, m = 0
 * (c) 当word[i].size() == L时。
 */
public class TextJustification_68 {
    public static void main(String[] args) {
        TextJustification_68 tj = new TextJustification_68();

        List<String> strings = tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        for(String s : strings) {
            System.out.println(s);
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();

        int index = 0;
        while (index < words.length) {
            int characterCnt = words[index].length();
            int wordCnt = 1;
            int next = index + 1;

            while (next < words.length) {
                if (characterCnt + 1 + words[next].length() > maxWidth) {
                    break;
                }

                characterCnt += words[next].length() + 1;
                next++;
                wordCnt++;
            }
            StringBuilder sb = new StringBuilder();
            if(next == words.length || wordCnt == 1){ // 到了最后一行或者只有一个单词
                for(int i = 0; i < wordCnt; i++){
                    sb.append(words[index + i] + " ");
                }

                sb.deleteCharAt(sb.length() - 1);

                // 后面补 space
                for( int i = sb.length(); i < maxWidth; i ++) {
                    sb.append(" ");
                }

            }
            else {
                int avgSpaces = (maxWidth - characterCnt) / wordCnt;
                if(avgSpaces == 0){
                    avgSpaces = 1;
                }
                int numOfWordsHavingMoreSpaces =  (maxWidth - characterCnt) % wordCnt; // 这句比较重要， 用来控制前面有多少个单词有 avgSpaces + 1 个空格

                for(int i = 0 ; i < wordCnt; ){
                    sb.append(words[index + i]);
                    if(i < wordCnt - 1){
                        if(i < numOfWordsHavingMoreSpaces) {
                            for(int j = 0 ; j < avgSpaces + 1; j++){
                                sb.append(" ");
                            }
                            i++;
                            continue;
                        }

                        for(int j = 0 ; j < avgSpaces; j++){
                            sb.append(" ");
                        }
                    }
                    i++;

                }
            }
            lines.add(sb.toString());
            index = next;
        }
        return lines;
    }
}
