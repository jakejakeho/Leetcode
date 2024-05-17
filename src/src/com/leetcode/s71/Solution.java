package src.com.leetcode.s71;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : path.toCharArray()) {
            if (c != '/')
                stringBuilder.append(c);
            else {
                stack.push(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(c);
            }
        }
        if (!stringBuilder.isEmpty()) {
            stack.push(stringBuilder.toString());
        }
        StringBuilder simplifyPath = new StringBuilder();
        int skip = 0;
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if ("/..".equals(current)) {
                skip++;
            } else if (!current.isEmpty()) {
                if (!"/".equals(current) && !"/.".equals(current)) {
                    if (skip > 0) {
                        skip--;
                    }else {
                        simplifyPath.insert(0, current);
                    }
                }
            }
        }
        if (simplifyPath.isEmpty()) {
            return "/";
        }
        return simplifyPath.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/.../a/../b/c/../d/./"));
    }
}