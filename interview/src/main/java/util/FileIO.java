package util;

import java.io.IOException;
import java.io.InputStream;
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
}
