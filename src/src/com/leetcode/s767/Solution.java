package src.com.leetcode.s767;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reorganizeString("vvvlo"));
    }

    public static final char[] charCache = getCharCache();

    private static char[] getCharCache() {
        char[] charCache = new char[26];
        for (int i = 0; i < 26; i++) {
            charCache[i] = (char)('a' + i);
        }
        return charCache;
    }

    public String reorganizeString(String s) {
        StringBuilder result = new StringBuilder();
        int[] conutMap = new int[26];
        char lastChar = 0;
        for (char c : s.toCharArray()) {
            conutMap[c - 'a']++;
        }

        while (result.length() < s.length()) {
            int lastSelectedCount = 0;
            int selected = -1;
            for (int i = 0; i < 26; i++) {
                if (conutMap[i] > 0 && conutMap[i] > lastSelectedCount && i != (lastChar - 'a')) {
                    lastSelectedCount = conutMap[i];
                    selected = i;
                }
            }
            if (selected == -1) {
                return "";
            }

            char nextChar = charCache[selected];
            conutMap[nextChar - 'a']--;
            result.append(nextChar);
            lastChar = nextChar;
        }
        return result.toString();
    }
}