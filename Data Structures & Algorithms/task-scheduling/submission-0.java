class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < tasks.length; i++){
            char curr = tasks[i];
            if (freq.containsKey(curr)){
                freq.put(curr, freq.get(curr)+1);
            }
            else {
                freq.put(curr, 1);
            }
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
        (a,b) -> freq.get(b) - freq.get(a));

        for (char character : freq.keySet()){
            maxHeap.add(character);
        }

        int time = 0;
        Queue<int[]> waitQueue = new LinkedList<>(); // [character, availableTime]
        
        while (!maxHeap.isEmpty() || !waitQueue.isEmpty()) {
            time++;
            
            // If we can execute a task
            if (!maxHeap.isEmpty()) {
                char task = maxHeap.poll();
                int remaining = freq.get(task) - 1;
                freq.put(task, remaining);
                
                // If still has remaining count, add to wait queue
                if (remaining > 0) {
                    waitQueue.add(new int[]{task, time + n});
                }
            }
            
            // Check if any waiting tasks are ready to go back to heap
            if (!waitQueue.isEmpty() && waitQueue.peek()[1] == time) {
                char readyTask = (char) waitQueue.poll()[0];
                maxHeap.add(readyTask);
            }
        }
        return time;


        
    }
}
