package src.com.leetcode.s953;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] priority = createPriority(order);
        for (int i = 1; i < words.length; i++) {
            if (!isAlienSorted(words[i - 1], words[i], priority)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlienSorted(String word1, String word2, int[] priority) {
        int smallLength = Math.min(word1.length(), word2.length());
        for (int i = 0; i < smallLength; i++) {
            int p1 = priority[word1.charAt(i) - 'a'];
            int p2 = priority[word2.charAt(i) - 'a'];
            if (p1 < p2) {
                return true;
            }
            else if (p1 > p2) {
                return false;
            }
        }
        return word1.length() <= word2.length();
    }

    private int[] createPriority(String order) {
        int[] priority = new int[26];
        int i = 0;
        for (char c : order.toCharArray()) {
            priority[c - 'a'] = i++;
        }
        return priority;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"app", "apple"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}