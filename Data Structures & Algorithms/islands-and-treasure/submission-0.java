class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        final int INF = 2147483647;
        
        // Add all gates to queue and mark as visited
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    visited.add(r + "," + c);
                }
            }
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= columns) {
                    continue;
                }
                
                String key = newRow + "," + newCol;
                if (visited.contains(key) || grid[newRow][newCol] != INF) {
                    continue;
                }
                
                grid[newRow][newCol] = grid[row][col] + 1;
                visited.add(key);
                q.offer(new int[]{newRow, newCol});
            }
        }
    }
}
