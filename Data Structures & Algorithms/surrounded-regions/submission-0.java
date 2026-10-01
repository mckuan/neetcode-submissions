class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (r == 0 || c == 0 || r == rows-1 || c == cols- 1){
                    if(board[r][c] == 'O'){
                        q.offer(new int[]{r,c});
                        visited[r][c] = true;
                        bfs(q, rows, cols, board, visited);
                    }
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++){
                if (board[r][c] == 'O' && !visited[r][c]){
                    board[r][c] = 'X';
                }
            }
        }

    }

    private void bfs(Queue<int[]> q, int rows, int cols, char[][] board, boolean[][] visited){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] dir : directions){
                int newrow = row + dir[0];
                int newcol = col + dir[1];

                if (newrow < 0 || newrow >= rows || newcol < 0 || newcol >= cols) continue;
                if (board[newrow][newcol] == 'X') continue;
                if (visited[newrow][newcol]) continue;
                
                int[] newcur = new int[] {newrow, newcol};
                q.offer(newcur);
                visited[newrow][newcol] = true;
            }
        }
    }
}
