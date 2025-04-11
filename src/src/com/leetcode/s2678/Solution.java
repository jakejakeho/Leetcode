package src.com.leetcode.s2678;

class Solution {

    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail: details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSeniors(new String[] {"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
        System.out.println(solution.countSeniors(new String[] {"1313579440F2036","2921522980M5644"}));
    }
}