package util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jianqsun on 3/31/14.
 */
public class Regex {
    public static void main(String[] args){
//        String a = "fefe";
//        String b = a.trim().replaceAll("\\\"$|^\\\"", ""); // will remove all the y from the end and x from the beggining
//        System.out.println(b);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("test", 1);
//        map.put("test1", "str");
//
//        for(Map.Entry<String, Object> entry : map.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue().toString());
//        }
          System.out.println(System.currentTimeMillis());
//        Regex r = new Regex();
//        r.test();
    }

    public void test(){
        String regex = "\\bcat\\b";
        Pattern pattern = Pattern.compile(regex);
        String line = "cat cat cat cattie cat";
        Matcher matcher = pattern.matcher(line);
        boolean matchFound = matcher.find();
        if (matchFound) {
            List<String> tokens = new ArrayList<String>(matcher.groupCount());
            for (int i = 1; i <= matcher.groupCount(); i++) {

                System.out.println(matcher.group(i));
            }

        }
    }

}
