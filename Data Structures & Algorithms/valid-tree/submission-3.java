class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjlist = new HashMap<>();
        int[] state = new int[n];

        for (int[] edge : edges){
            int node = edge[0];
            int child = edge[1];

            adjlist.putIfAbsent(node, new ArrayList<>());
            adjlist.putIfAbsent(child, new ArrayList<>());
            adjlist.get(node).add(child);
            adjlist.get(child).add(node);
        }

        if (detectCycle(state, adjlist, 0, 0)) return false;

        for (int node = 0; node < n; node++){
            if (state[node] != 2){
               return false; 
            }
        }
        return true;
    }

    private boolean detectCycle(int[] state, HashMap<Integer, List<Integer>> adjlist, 
    int node, int parent){
        
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;

        state[node] = 1;
        if (adjlist.containsKey(node)){
            for (int child : adjlist.get(node)){
                if (child == parent) continue;
                if (detectCycle(state, adjlist, child, node)) return true;
            }
        }

        state[node] = 2;
        return false;
    }
}
