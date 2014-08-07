package util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jianqsun on 3/10/14.
 */
public class FileIO {
    public static void main(String[] args){
        URL url;
        try {
            url = new URL("file:///S:/Code/IntelliJ/myjava/interview/src/main/resources/data.txt");
            URLConnection urlConnection = url.openConnection();
            InputStream input = urlConnection.getInputStream();

            System.out.println(url.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String readTextFile(String fileName) {

        String returnValue = "";
        FileReader file = null;

        try {
            file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);
            String line = "";
            while ((line = reader.readLine()) != null) {
                returnValue += line + "\n";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    // Ignore issues during closing
                }
            }
        }
        return returnValue;
    }

    public void writeTextFile(String fileName, String s) {
        FileWriter output = null;
        try {
            output = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    // Ignore issues during closing
                }
            }
        }

    }
}
