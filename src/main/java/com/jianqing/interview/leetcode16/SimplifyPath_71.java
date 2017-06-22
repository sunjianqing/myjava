package com.jianqing.interview.leetcode16;

import java.util.Stack;

/**
 * Created by jianqing_sun on 6/15/17.
 */
public class SimplifyPath_71 {
    public static void main(String[] args) {
        SimplifyPath_71 sp  = new SimplifyPath_71();
        System.out.println(sp.simplifyPath("/..."));
        System.out.println(sp.simplifyPath("/home/"));
        System.out.println(sp.simplifyPath("/a/./b/../../c/"));
        System.out.println(sp.simplifyPath("/home//foo"));
        System.out.println(sp.simplifyPath("/a/./b/../c/"));
        System.out.println(sp.simplifyPath("/a/./b/c/"));
    }
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }

        Stack<String> stack = new Stack<>();

        int i = 0;
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c == '/') {
                // find next non '/'
                int j = i;
                while (j < path.length()) {
                    if (path.charAt(j) == '/') {
                        j++;
                        continue;
                    } else
                        break;
                }
                i = j;
            } else if (c == '.') {
                if (i + 1 < path.length()) {
                    if (path.charAt(i + 1) == '.') {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        i = i + 2;
                    } else if (path.charAt(i + 1) == '/') {
                        i = i + 2;
                        continue;
                    }
                }
                else
                    i++;
            } else {
                int j = i;
                while (j < path.length()) {
                    if(path.charAt(j) != '/' && path.charAt(j) != '.'){
                        j++;
                        continue;
                    }
                    else
                        break;
                }
                stack.push(path.substring(i, j));
                i = j;
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder("");

        while (!stack.isEmpty()){
            sb.insert(0, "/" + stack.pop());
        }

        return sb.toString();
    }

}
