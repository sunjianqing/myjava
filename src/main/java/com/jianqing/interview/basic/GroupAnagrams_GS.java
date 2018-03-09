package com.jianqing.interview.basic;

/* Problem Name is &&& Group Anagrams &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Given a list of words, group them by anagrams
 *     Input: List of "cat", "dog", "god"
 *     Output: A Set of Sets of anagrams: {{'cat'}, {'dog', 'god'}}
 *  2) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  3) Consider adding some additional tests in doTestsPass().
 *  4) Implement the AnagramSolution group() method correctly.
 *  5) If time permits, try to improve your implementation.
 */

import java.util.*;

/* Problem Name is &&& Group Anagrams &&& PLEASE DO NOT REMOVE THIS LINE. */
/**
 * Instructions to candidate.
 * 1) Given a list of words, group them by anagrams
 * Input: List of "cat", "dog", "god"
 * Output: A Set of Sets of anagrams: {{'cat'}, {'dog', 'god'}}
 * 2) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 3) Consider adding some additional tests in doTestsPass().
 * 4) Implement the AnagramSolution group() method correctly.
 * 5) If time permits, try to improve your implementation.
 */


/*
 * To execute Java, please define "static void main" on a class
 * named GroupAnagrams_GS.
 *
 * If you need more classes, simply define them inline.
 */
public class GroupAnagrams_GS {

    /**
     * A means for grouping words by anagram (same letters irrespective of order)
     */
    @FunctionalInterface
    interface AnagramSolution {
        Set<Set<String>> group(List<String> words);
    }



    /**
     * public static boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false
     */
    public static boolean doTestsPass(){
        // todo: implement more tests, please
        // feel free to make testing more elegant

        // given some words
        List<String> words = Arrays.asList("cat", "dog", "god", "cat", "hello", "ollhe", "ellho");


        // todo : and a solution to the problem
        AnagramSolution sol = new AnagramSolution(){

            public Set<Set<String>> group(List<String> words) {

                Map<String, Set<String>> map = new HashMap<>();

                Set<Set<String>> res = new HashSet<>();

                if(words == null || words.size() ==0) {
                    return res;
                }

                for(int i = 0; i < words.size(); i++){
                    char[] chars = words.get(i).toCharArray();
                    Arrays.sort(chars);

                    String key = new String(chars);

                    if(map.containsKey(key)){
                        map.get(key).add(words.get(i));
                    }
                    else{
                        Set<String>  l = new HashSet<>();
                        l.add(words.get(i));
                        map.put(key, l);
                    }
                }

                res.addAll(map.values());
                return res;
            }
        };

        // when grouped
        Set<Set<String>> grouped = sol.group(words);

        // we expect god and dog to be identified as anagrams, whilst cat isn't
        boolean result = true;
        result = result && grouped.contains(new HashSet<>(Arrays.asList("cat")));
        result = result && grouped.contains(new HashSet<>(Arrays.asList("dog", "god")));
        result = result && grouped.contains(new HashSet<>(Arrays.asList("ellho","hello", "ollhe")));

        return result;
    };


    /**
     * Execution entry point.
     */
    public static void main(String[] args){
        if(doTestsPass()){
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }

    }
}
