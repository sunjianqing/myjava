package com.jianqing.interview;

import java.io.*;
import java.util.Scanner;

/**
 * Created by jianqsun on 2/3/14.
 */
public class FileIO {
    public static void main(String[] args){

    }

    public void read(String fileName){
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
            String line = null;
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            bufferedReader.read();
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Always wrap FileReader in BufferedReader.


    }
}
