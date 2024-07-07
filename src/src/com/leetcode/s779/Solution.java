package src.com.leetcode.s779;

class Solution {
    public int kthGrammar(int n, int k) {
        StringBuilder current = new StringBuilder("0");
        for (int i = 0; i < n - 1; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(j) == '1') {
                    temp.append("10");
                } else {
                    temp.append("01");
                }
            }
            current = temp;
        }
        return current.charAt(k - 1) - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthGrammar(1, 1));
        System.out.println(solution.kthGrammar(2, 1));
        System.out.println(solution.kthGrammar(2, 2));
    }
}