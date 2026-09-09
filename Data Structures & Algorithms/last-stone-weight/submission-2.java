class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x != y){
                int z = Math.abs(x-y);
                maxHeap.add(z);
            }
        }

        if (maxHeap.size() == 0) return 0;
        return maxHeap.peek();
    }
}
