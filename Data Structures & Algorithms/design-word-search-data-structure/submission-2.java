public class TrieNode {
    TrieNode[] alphabet = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.alphabet[c] == null) {
                cur.alphabet[c] = new TrieNode();
            }
            cur = cur.alphabet[c];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode cur) {
        // Base case: consumed the whole word
        if (index == word.length()) {
            return cur.endOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // Try every possible child; if any path works, we're good
            for (int j = 0; j < 26; j++) {
                if (cur.alphabet[j] != null) {
                    if (searchHelper(word, index + 1, cur.alphabet[j])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int c = ch - 'a';
            if (cur.alphabet[c] == null) {
                return false;
            }
            return searchHelper(word, index + 1, cur.alphabet[c]);
        }
    }
}