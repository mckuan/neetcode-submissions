//reminds me of the hard tree traversal problem, same idea
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length; //get rows
        int columns = grid[0].length; // get columns

        Queue<int[]> q = new LinkedList<>(); 
        //instatiate a q that holds our curr positions as [r,c]
        final int INF = 2147483647;


        for (int r = 0; r < rows; r++){
            for (int c = 0; c <columns; c++){
                if (grid[r][c] == 0){
                    //traverse through the grid if grid[r][c] = gate
                    int[] curr = new int[]{r,c};
                    q.offer(curr);
                    //add to the queue and visited
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // double array for all possible directions we can travel in

        while (!q.isEmpty()){
            //pop the queue and obtain the r c 
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            //for each direction in direction 
            for (int[] dir : directions){
                int newrow = dir[0] + row;
                int newcol = dir[1] + col;

                //if its out of bounds
                if (newrow < 0 || newrow >= rows || newcol < 0 || newcol >= columns) continue;
                if (grid[newrow][newcol] != INF) continue;

                // add one to it from prev
                grid[newrow][newcol] = grid[row][col]+1;
                int[] newcur = new int[] {newrow, newcol};

                //add to visited and queueq
                q.offer(newcur);
            }
        }
        
    }
}



//         int rows = grid.length;
//         int columns = grid[0].length;
        
//         Queue<int[]> q = new LinkedList<>();
//         HashSet<String> visited = new HashSet<>();
//         final int INF = 2147483647;
        
//         // Add all gates to queue and mark as visited
//         for (int r = 0; r < rows; r++) {
//             for (int c = 0; c < columns; c++) {
//                 if (grid[r][c] == 0) { //if its a gate
//                     q.offer(new int[]{r, c}); //add to queue
//                     visited.add(r + "," + c); // add to visited
//                 }
//             }
//         }
        
//         // all possible directions
//         int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
//         //while queue is not empty
//         while (!q.isEmpty()) {
//             int[] current = q.poll(); //you pop it 
//             int row = current[0];// this is where you are 
//             int col = current[1];
            
//             for (int[] dir : directions) {// travel in all 4 directions
//                 int newRow = row + dir[0];
//                 int newCol = col + dir[1];
                
//                 //if its off the grid continue 
//                 if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= columns) {
//                     continue;
//                 }
//                 //create key
//                 String key = newRow + "," + newCol;
//                 //if this is a wall or already visited we continue
//                 if (visited.contains(key) || grid[newRow][newCol] != INF) {
//                     continue;
//                 }
//                 //we increment this new position with prev position + 1
//                 grid[newRow][newCol] = grid[row][col] + 1;
//                 //add it to visited
//                 visited.add(key);
//                 //add it to queue
//                 q.offer(new int[]{newRow, newCol});
//             }
//         }
