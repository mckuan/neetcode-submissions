class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int min = 0;
        int freshcount = 0;

        Queue<int[]> q = new LinkedList<>(); 

        for(int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 2){
                    q.offer(new int[] {r,c});
                }
                if (grid[r][c] == 1){
                    freshcount++;
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++){
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];

                for (int[] dir : directions){
                    int newrow = row + dir[0];
                    int newcol = col + dir[1];

                    if (newrow < 0 || newrow >= rows || newcol < 0 || newcol >= cols) continue;
                    if ( grid[newrow][newcol] != 1) continue;

                
                    grid[newrow][newcol] = 2;
                    q.offer(new int[] {newrow, newcol});
                    freshcount --; 
                    rotted = true;

                }
            }
            if (rotted) min ++;
        }
        if (freshcount != 0) return -1;
        return min;
    }
}
