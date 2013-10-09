package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException ;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 10/8/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleIO {
    public String consoleRead(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String readLine = br.readLine();
            return readLine;
        }
        catch (IOException e)   {
            e.printStackTrace();
            return null;
        }
    }
}
