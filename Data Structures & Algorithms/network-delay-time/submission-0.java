//Djikstra
// we first put all the edges into a map 
// and then we create a min heap, with our start, and we pop utnil we reach end
public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> edges = new HashMap<>();
        //so we split into time arrays
        // start node, end node, time
        for (int[] time : times){
            //put start node as the key
            edges.computeIfAbsent (time[0], key -> new ArrayList<>());
            //in the list we add the target node and the time
            edges.get(time[0]).add(new int[] {time[1], time[2]});
        }

        //we create a minheap where we will maintaining by comparing the time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {0,k});
        // all our data in the minheap is stored (time to reach, node)
        //add in first node (takes 0 time to reach)

        Set<Integer> visited = new HashSet<>();
        //keep track of time used so far
        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            //pop the min route (current min route)
            //save the time and node add it to visited and set t to time
            int time = curr[0];
            int node = curr[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            t = time;

            //if there exists neighbors we visit neighbor
            //if not visited yet, we add the node into minheap (time total to get here, node)
            if (edges.containsKey(node)){
                for (int[] nei : edges.get(node)){
                    int time2 = nei[1];
                    int node2 = nei[0];
                    if (!visited.contains(node2)){
                        minHeap.add(new int[] {time+time2, node2});
                    }
                }
            }
        }
        //when the minheap is empty its either bc we visited everyone or we didnt
        //either way traversal done
        //if size = n then we visited everyone and return t, if not -1
        return visited.size() == n ?t : -1;
        
    }
}

// Map<Integer, List<int[]>> edges = new HashMap<>();
//         for (int[] time : times) {
//             edges.computeIfAbsent(time[0],
//             key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
//         }

//         PriorityQueue<int[]> minHeap = new PriorityQueue<>(
//         Comparator.comparingInt(a -> a[0]));
//         minHeap.offer(new int[]{0, k});

//         Set<Integer> visited = new HashSet<>();
//         int t = 0;
//         while (!minHeap.isEmpty()) {
//             int[] curr = minHeap.poll();
//             int w1 = curr[0], n1 = curr[1];
//             if (visited.contains(n1)) {
//                 continue;
//             }
//             visited.add(n1);
//             t = w1;

//             if (edges.containsKey(n1)) {
//                 for (int[] next : edges.get(n1)) {
//                     int n2 = next[0], w2 = next[1];
//                     if (!visited.contains(n2)) {
//                         minHeap.offer(new int[]{w1 + w2, n2});
//                     }
//                 }
//             }
//         }

//         return visited.size() == n ? t : -1;