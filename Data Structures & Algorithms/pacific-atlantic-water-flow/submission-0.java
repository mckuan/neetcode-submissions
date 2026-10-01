class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       
        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;
        Queue<int[]> q = new LinkedList<>();

        boolean[][] canReachPacific = new boolean[rows][cols];
        boolean[][] canReachAtlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols ; c++){
                if (r == 0 || c == 0){
                    q.offer(new int[] {r,c});
                    canReachPacific[r][c] = true;
                    traverse(heights, q, canReachPacific, rows, cols);
                } 
                if (r == rows - 1 || c == cols - 1){
                    q.offer(new int[] {r,c});
                    canReachAtlantic[r][c] = true;
                    traverse(heights, q, canReachAtlantic, rows, cols);
                }
            }
        }

       for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (canReachPacific[r][c] && canReachAtlantic[r][c]) {
                    List<Integer> ans = new ArrayList<>(); 
                    ans.add(r);
                    ans.add(c);
                    res.add(ans);
                }
            }
       }
        return res;

    }

    private void traverse(int[][] grid, Queue<int[]> q, boolean[][] ocean, int rows, int cols){
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1]; 

            for (int[] dir : directions){
                int newrow = row + dir[0];
                int newcol = col + dir[1];
                if (newrow < 0 || newrow >= rows || newcol < 0 || newcol >= cols) continue;
                if (grid[newrow][newcol] < grid[row][col]) continue;
                if(ocean[newrow][newcol]) continue;

                int[] newcur = new int[] {newrow, newcol};
                q.offer(newcur);
                ocean[newrow][newcol] = true;
                
            }

        } 
        
    }
}
