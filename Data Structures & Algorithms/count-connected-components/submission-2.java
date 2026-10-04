class Solution {
    public int countComponents(int n, int[][] edges) {

        HashMap<Integer, List<Integer>> adjlist = new HashMap<>();
        int[] state = new int[n];
        int ans = 0;

        for (int[] edge : edges){
            int node = edge[0];
            int child = edge[1];

            adjlist.putIfAbsent(node, new ArrayList<>());
            adjlist.putIfAbsent(child, new ArrayList<>());
            adjlist.get(node).add(child);
            adjlist.get(child).add(node);
        }

        for (int node = 0; node < n; node++){
            if (state[node] != 1) {
                traverse(state, adjlist, node, node);
                ans++;
            }
        }
        return ans;
    }

    private void traverse(int[] state, HashMap<Integer, List<Integer>> adjlist, int node, int parent){
        if (state[node] == 1) return;

        state[node] = 1;

        if (adjlist.containsKey(node)){
            for (int child : adjlist.get(node)){
                if (parent == child) continue;
                traverse(state, adjlist, child, node);
            }
        }
    }
}
