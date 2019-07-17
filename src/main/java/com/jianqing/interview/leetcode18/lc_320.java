package com.jianqing.interview.leetcode18;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Generalized Abbreviation
 *
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 * pos: points to the current string
 * cnt: how many letters are abbreviated in the current streak
 * cur: current string formed
 *
 */
public class lc_320 {

    public static void main(String[] args) {
        lc_320 lc = new lc_320();

        List<String> word = lc.generateAbbreviations("word");


    }
    public List<String> generateAbbreviations(String word) {

        List<String> res = new ArrayList<>();
        DFS(res, "", word, 0, 0);
        return res;
    }

    private void DFS(List<String> res, String sb, String word, int cnt, int pos) {

        if(pos == word.length()) {
            if(cnt > 0){
                sb = sb + cnt;
            }

            res.add(sb);
            return;
        }

        // abbreviate this letter
        DFS(res, sb, word, cnt + 1, pos + 1);

        // Do not abbreviate this letter
        if(cnt > 0){
            sb += cnt;
        }
        sb += word.charAt(pos);

        DFS(res, sb, word, 0, pos+1);

    }


}
