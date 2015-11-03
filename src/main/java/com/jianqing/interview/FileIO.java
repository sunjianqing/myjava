package com.jianqing.interview;

import java.io.*;
import java.util.Scanner;

/**
 * Created by jianqsun on 2/3/14.
 */
public class FileIO {
    public static void main(String[] args){
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        FileIO io = new FileIO();
        io.printResourcesPath();
    }

    public void printResourcesPath(){
        System.out.print(getClass().getClassLoader().getResource("data.txt"));
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
