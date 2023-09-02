package src.com.leetcode.s208;

class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

    Trie[] trieHashMap;
    boolean isWordEnd;

    public Trie() {
        trieHashMap = new Trie[26];
        isWordEnd = false;
    }

    public void insert(String word) {
        Trie lastTrie = this;
        for (char c : word.toCharArray()) {
            if (lastTrie.trieHashMap[c - 'a'] == null) {
                lastTrie.trieHashMap[c - 'a'] = new Trie();
            }
            lastTrie = lastTrie.trieHashMap[c - 'a'];
        }
        lastTrie.isWordEnd = true;
    }

    public boolean search(String word) {
        Trie pointer = this;
        for (char c : word.toCharArray()) {
            if (pointer.trieHashMap[c - 'a'] == null) {
                return false;
            } else {
                pointer = pointer.trieHashMap[c - 'a'];
            }
        }
        return pointer.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        Trie pointer = this;
        for (char c : prefix.toCharArray()) {
            if (pointer.trieHashMap[c - 'a'] == null) {
                return false;
            } else {
                pointer = pointer.trieHashMap[c - 'a'];
            }
        }
        return true;
    }

}
