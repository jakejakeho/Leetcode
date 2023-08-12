package src.com.leetcode.s211;

public class WordDictionary {
    WordDictionary[] wordDictionaries;
    boolean isWordEnd;

    public WordDictionary() {
        wordDictionaries = new WordDictionary[26];
        isWordEnd = false;
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        WordDictionary current = this;
        for (char c : chars) {
            if (current.wordDictionaries[c - 'a'] == null) {
                current.wordDictionaries[c - 'a'] = new WordDictionary();
            }
            current = current.wordDictionaries[c - 'a'];
        }
        current.isWordEnd = true;
    }

    public boolean search(String word) {
        return search(word, this);
    }

    private boolean search(String word, WordDictionary current) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                String subStr = word.substring(i + 1);
                for (WordDictionary wordDictionary : current.wordDictionaries) {
                    if (wordDictionary != null && wordDictionary.search(subStr, wordDictionary)) {
                            return true;
                    }
                }
                return false;
            } else {
                if (current.wordDictionaries[c - 'a'] != null) {
                    current = current.wordDictionaries[c - 'a'];
                } else {
                    return false;
                }
            }
        }
        return current.isWordEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        System.out.println(wordDictionary.search("b.."));
    }
}
