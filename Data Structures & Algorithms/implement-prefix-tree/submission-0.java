//create a TrieNode class **practice creating classes/objects
public class TrieNode {
    TrieNode[] alphabet = new TrieNode[26];
    boolean endOfWord = false;
}

//the concept is that each node is a 26 alphabet array and you connect them to each other
//to form a tree
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        //create trie copy of root
        TrieNode cur = root;
        //traverse through the copy
        for (int i = 0 ; i < word.length(); i++){
            char j = word.charAt(i);
            int c = j - 'a';
            // get the alphabet in number

            //we check current node.alphabet(next letter) if its not the one from word
            if (cur.alphabet[c] == null){
                cur.alphabet[c] = new TrieNode(); 
                //if no match we create a new trie for that alphabet
            }
            
            cur = cur.alphabet[c];
            //move to next letter
        }
        cur.endOfWord = true;
        //finished adding the word mark the end
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0 ; i < word.length(); i++){
            char j = word.charAt(i);
            int c = j - 'a';
            if (cur.alphabet[c] == null) return false;
            cur = cur.alphabet[c];
        }
        if (cur.endOfWord == true) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur =root;
        for (int i = 0; i < prefix.length(); i++){
            char j = prefix.charAt(i);
            int c = j - 'a';
            if (cur.alphabet[c] == null) return false;
            cur = cur.alphabet[c];
        }
        return true;
    }
}
