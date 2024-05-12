package src.com.leetcode.s1456;

class Solution {
    public int maxVowels(String s, int k) {
        int[] countArr = new int[26];
        for (int i = 0; i < k; i++) {
            countArr[s.charAt(i) - 'a']++;
        }

        int maxVowels = numOfVowels(countArr);
        if (maxVowels == k) {
            return maxVowels;
        }
        for (int i = 0; i < s.length() - k; i++) {
            countArr[s.charAt(i) - 'a']--;
            countArr[s.charAt(i + k) - 'a']++;
            int currentVowels = numOfVowels(countArr);
            if (currentVowels > maxVowels) {
                maxVowels = currentVowels;
            }
            if (maxVowels == k) {
                return maxVowels;
            }
        }
        return maxVowels;
    }

    private int[] vowels = new int[]{
            'a' - 'a',
            'e' - 'a',
            'i' - 'a',
            'o' - 'a',
            'u' - 'a'
    };

    private int numOfVowels(int[] countArr) {
        int count = 0;
        for (int vowel : vowels) {
            count += countArr[vowel];
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxVowels("abciiidef", 3));
        System.out.println(solution.maxVowels("aeiou", 2));
        System.out.println(solution.maxVowels("leetcode", 3));
    }
}