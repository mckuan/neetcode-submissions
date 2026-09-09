class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[i].length; j++){
                if (backtrack(board, word, i,j,0,used )) return true;
            }
        }  
        return false;      
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index, boolean[][] used) {

        if (index == word.length()) return true;

        //character still on board check
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        
        //character isnt right check
        if (board[row][col] != word.charAt(index)) return false;
        //character isnt used check
        if (used[row][col]) return false;

        used[row][col] = true;

        //need to return true each backtrack to track success, otherwise it returns false at line 40
        if (backtrack(board, word, row, col+1, index + 1, used)) return true;
        if (backtrack(board, word, row, col-1, index + 1, used)) return true;
        if (backtrack(board, word, row+1, col, index + 1, used)) return true;
        if (backtrack(board, word, row-1, col, index + 1, used)) return true;

        // unmark to clear for next looking 
        used[row][col] = false;
        return false;
    }
}
