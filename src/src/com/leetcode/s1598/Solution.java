package src.com.leetcode.s1598;

class Solution {

    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (level > 0)
                    level--;
            } else if ("./".equals(log)) {

            } else {
                level++;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new String[]{
                "d1/", "d2/", "../", "d21/", "./"
        }));
        System.out.println(solution.minOperations(new String[]{
                "d1/", "d2/", "./", "d3/", "../", "d31/"
        }));
        System.out.println(solution.minOperations(new String[]{
                "d1/", "../", "../", "../"
        }));
    }
}