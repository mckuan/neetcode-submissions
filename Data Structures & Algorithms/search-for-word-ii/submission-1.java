class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // store the full word at the terminal node
    }

    private TrieNode root = new TrieNode();
    private List<String> res = new ArrayList<>();
    private int ROWS, COLS;

    public List<String> findWords(char[][] board, String[] words) {
        // 1. Build trie
        for (String w : words) {
            TrieNode cur = root;
            for (char ch : w.toCharArray()) {
                int c = ch - 'a';
                if (cur.children[c] == null) cur.children[c] = new TrieNode();
                cur = cur.children[c];
            }
            cur.word = w;
        }

        ROWS = board.length;
        COLS = board[0].length;

        // 2. DFS from every cell
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS) return;

        char ch = board[r][c];
        if (ch == '*' || node.children[ch - 'a'] == null) return;

        TrieNode next = node.children[ch - 'a'];

        // Found a complete word — record it and null it out to dedupe
        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }

        board[r][c] = '*';
        dfs(board, r + 1, c, next);
        dfs(board, r - 1, c, next);
        dfs(board, r, c + 1, next);
        dfs(board, r, c - 1, next);
        board[r][c] = ch;

        // Optional optimization: prune leaf nodes once fully explored
        // (skip this if you want simpler code)
    }
}