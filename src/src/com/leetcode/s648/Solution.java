package src.com.leetcode.s648;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> map = new HashMap<>();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode rootNode = new TrieNode();
        for (String s : dictionary) {
            TrieNode pointer = rootNode;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                pointer.map.computeIfAbsent(c, k -> new TrieNode());
                if (i == arr.length - 1) {
                    pointer.map.get(c).isEndOfWord = true;
                }
                pointer = pointer.map.get(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        var sentenceArr = sentence.toCharArray();
        for (int i = 0; i < sentence.length(); i++) {
            boolean replaced = false;
            TrieNode pointer = rootNode;
            StringBuilder temp = new StringBuilder();
            int checkPointer = i;
            while (checkPointer < sentenceArr.length && sentenceArr[checkPointer] != ' ') {
                if (!pointer.map.containsKey(sentenceArr[checkPointer])) {
                    break;
                }
                temp.append(sentenceArr[checkPointer]);
                if (pointer.map.get(sentenceArr[checkPointer]).isEndOfWord) {
                    stringBuilder.append(temp);
                    replaced = true;
                    break;
                }
                pointer = pointer.map.get(sentenceArr[checkPointer]);
                checkPointer++;
            }
            while (i < sentenceArr.length && sentenceArr[i] != ' ') {
                if (!replaced)
                    stringBuilder.append(sentenceArr[i]);
                i++;
            }
            if (i != sentenceArr.length)
                stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(List.of("cat", "bat", "rat"),
                "the cattle was rattled by the battery"
        ));
    }
}