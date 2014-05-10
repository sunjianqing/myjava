package com.jianqng.basic.multithreading;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 1/24/14
 * Time: 5:31 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class StreamToken {
    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(
                new StringReader("Mary  had+1 little lamb..."));

        while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){

            if(tokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println(tokenizer.sval);
            } else if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(tokenizer.nval);
            } else if(tokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println();
            }

        }
    }
}
