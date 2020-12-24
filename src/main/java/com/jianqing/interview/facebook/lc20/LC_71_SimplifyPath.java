package com.jianqing.interview.facebook.lc20;

import java.util.Stack;

/**
 * "/home/"
 * "/home"
 * <p>
 * "/../"
 * "/"
 * <p>
 * "/home//foo/"
 * "/home/foo"
 * <p>
 * "/a/./b/../../c/"
 * "/c"
 */
public class LC_71_SimplifyPath {

    public static void main(String[] args) {
        LC_71_SimplifyPath lc = new LC_71_SimplifyPath();
        String input = "/home/";
        lc.simplifyPath(input);
    }

    /**
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        String[] splits = path.split("/");
        for (String input : splits) {
            String s = input.trim();
            if (s.equals(".")){
                continue;
            }

            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            if (!s.isEmpty()) {
                // split by "/" 的时候， s might be empty， 比如 /home => ["", "home"]
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        String result = "";
        while (!stack.isEmpty()) {
            String current = stack.pop();
            result = "/" + current + result;
        }
        return result;
    }
}
