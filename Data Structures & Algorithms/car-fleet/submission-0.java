class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        
        double[][] sorted = new double[n][2];  // Fix: specify dimensions
        
        for (int i = 0; i < position.length; i++) {
            sorted[i][0] = position[i];  // Store position
            // Fix: use double division, Math.ceil not needed
            sorted[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        // Sort by position in descending order
        Arrays.sort(sorted, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double maxTime = -1.0;
        
        for (int i = 0; i < sorted.length; i++) {
            double currentTime = sorted[i][1];
            // If current time is greater than all times ahead,
            // it forms a new fleet
            if (currentTime > maxTime) {
                fleets++;
                maxTime = currentTime;
            }
        }
        
        return fleets;
    }
}
