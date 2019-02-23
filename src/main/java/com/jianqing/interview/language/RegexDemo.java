package com.jianqing.interview.language;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jianqing_sun on 3/8/18.
 *
 X?	X occurs once or not at all
 X+	X occurs once or more times
 X*	X occurs zero or more times
 .	Any character (may or may not match terminator)
 \d	Any digits, short of [0-9]
 \D	Any non-digit, short for [^0-9]
 \s	Any whitespace character, short for [\t\n\x0B\f\r]
 \S	Any non-whitespace character, short for [^\s]
 \w	Any word character, short for [a-zA-Z_0-9]
 \W	Any non-word character, short for [^\w]
 \b	A word boundary
 \B	A non word boundary

 */
public class RegexDemo {
    public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";
    public static final String LOG_TEST = "[02/01/2014 5:7:8 + 0000] PUT /user/4324/riders/543534 HTTP1.1 304 chrome";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\[.*\\])\\s+(.*)");
        Pattern upattern = Pattern.compile("/user/(\\d+)/");
        Matcher matcher = pattern.matcher(LOG_TEST);
        int cnt = matcher.groupCount();
        System.out.println(cnt);
        // check all occurance
        while (matcher.find()) {
            //System.out.print("Start index: " + matcher.start());
            //System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2)); // PUT /user/4324/riders/543534 HTTP1.1 304 chrome

            String str = matcher.group(2);
            Matcher umatcher = upattern.matcher(str);
            while(umatcher.find()){
                System.out.println(umatcher.group(0)); // /user/4324/

                System.out.println(umatcher.group(1)); // 4324
            }
        }

    }
}
