package src.com.leetcode.s165;

class Solution {

    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {
            int x = 0;
            for (; i < version1.length() && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++;

            int y = 0;
            for (; j < version2.length() && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++;

            if (x != y) {
                return x < y ? -1 : 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("1.01", "1.001"));
        System.out.println(solution.compareVersion("1.0", "1.0.0"));
        System.out.println(solution.compareVersion("0.1", "1.1"));
        System.out.println(solution.compareVersion("1.1", "1"));
    }
}