class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0; 
        while (i < matrix.length){
            if (target > matrix[i][matrix[i].length-1])i++;
            else break;
        }
        if (i == matrix.length) return false;
        for (int j = 0; j < matrix[i].length; j++){
            if (matrix[i][j] == target) return true;
        }
        return false;
    }
}
