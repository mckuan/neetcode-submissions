class Solution {
    public boolean isValidSudoku(char[][] board) {

        //check vertical
        for (int i = 0; i < 9; i++){
            int[] vertical = new int[9];
            for (int j = 0; j<9; j++){
                if(Character.isDigit(board[i][j])){
                    int currV = board[i][j] - '0' - 1;
                    if(vertical[currV]!= 0) return false;
                    else vertical[currV]++;
                }
            }
        }

        //check horizontal
        for (int i = 0; i < 9; i++){
            int[] horizontal = new int[9];
            for (int j = 0; j<9; j++){
                if(Character.isDigit(board[j][i])){
                    int currH = board[j][i] - '0' - 1;
                    if(horizontal[currH]!= 0) return false;
                    else horizontal[currH]++;
                }
            }
        }

        //check box
    for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                int[] freq = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int actualRow = blockRow * 3 + i;
                        int actualCol = blockCol * 3 + j;
                        if (Character.isDigit(board[actualRow][actualCol])) {
                            int num = board[actualRow][actualCol] - '0' - 1;
                            if (freq[num] != 0) return false;
                            freq[num]++;
                        }
                    }
                }
            }
        }


        
        return true;
    }
}
