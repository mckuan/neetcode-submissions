class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>
        ((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for (int i = 0; i < points.length; i++){
            if (maxHeap.size() < k) {
                maxHeap.add(points[i]);
            } else {
                int x = points[i][0];
                int y = points[i][1];
                int[] curr = maxHeap.peek();

                if (curr[0]*curr[0] + curr[1]*curr[1] > x*x + y*y){
                    maxHeap.remove();
                    maxHeap.add(points[i]);
                }
            }
        }

        int i = 0;
        int[][] res = new int[maxHeap.size()][2];
        while (!maxHeap.isEmpty()){
            res[i] = maxHeap.peek();
            maxHeap.remove();
            i++;
        }
        return res;
 
    }
}
