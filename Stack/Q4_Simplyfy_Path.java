package Stack;

import java.util.LinkedList;

/*
 !Name: Aritra Ghorai
 !Date:17/03/2022
 ?Program Details:71. Simplify Path
 *https://leetcode.com/problems/simplify-path/ 
   */
public class Q4_Simplyfy_Path {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }

    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        var Stack = new LinkedList<String>();
        for (String s : paths) {
            if (!Stack.isEmpty() && s.equals(".."))
                Stack.pop();
            else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                Stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (Stack.isEmpty())
            return "/";
        while (!Stack.isEmpty()) {
            sb.insert(0, Stack.pop()).insert(0, "/");
        }
        return sb.toString();
    }
}
