class Solution {
    private static final int[][] directions = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };
    private int curr = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 1){
                     dfs(grid, r, c);
                    if (curr > max) max = curr;
                    curr = 0;
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return;
        }

        grid[r][c] = 0;
        curr++;

        for (int[] dir : directions){
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
