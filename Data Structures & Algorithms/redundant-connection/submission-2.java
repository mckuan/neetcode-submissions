public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1 ];
        int[] rank = new int[edges.length + 1];

        for (int i = 0; i < par.length; i++){
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            if (!union(par, rank, node1, node2)){
                return new int[] {node1,node2};
            }
        }
        return new int[0]; 
    }

    private int find(int[] par, int node){
        int p = par[node];
        while (par[p] != p){
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union( int[] par, int[] rank, int node1, int node2){
        int p1 = find(par, node1);
        int p2 = find(par, node2);

        if (p1==p2) return false;
        else if (rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

// learn union find

//   int[] par = new int[edges.length + 1];
//         // par[x] : shows you who the parent of x is, bc theres only edge.length+1 since nodes start at 1

//         int[] rank = new int[edges.length + 1];
//         //rank/componenet, how big each tree is so far in the union find, the max it can be is n+1 amount of nodes (since we start from 1)

//         // we traverse through the and set up as n+1 all individual components
//         for (int i = 0; i < par.length; i++) {
//             par[i] = i;
//             rank[i] = 1;
//         }

//         // now go through the edges
//         for (int[] edge : edges) {
//             //if we get false from union we return that edge bc that created a cycle
//             if (!union(par, rank, edge[0], edge[1]))
//                 return new int[]{edge[0], edge[1]};
//         }
//         return new int[0];
//     }

//     //find function used in union
//     //return the parent given int n
//     private int find(int[] par, int n) {
//         // int parent immediate parent
//         int p = par[n];
//         while (p != par[p]) {//p = par[p] when its the root of the componenet
//             par[p] = par[par[p]];// so we traverse up the tree 
//             p = par[p];
//         }
//         //when it is the final root we return
//         return p;
//     }

//     //union function
//     //union two components given two nodes/one edge
//     private boolean union(int[] par, int[] rank, int n1, int n2) {

//         //find the two ultimate roots of the two nodes
//         int p1 = find(par, n1);
//         int p2 = find(par, n2);

//         //if they are equal, the are in the same componenet
//         if (p1 == p2)
//         //if they were already connected that means this edge creates a cycle
//             return false;
//         // arent connected, if componenet 1 > componenet 2 1 is root of 2
//         if (rank[p1] > rank[p2]) {
//             par[p2] = p1;
//             rank[p1] += rank[p2];
//         //vise versa
//         } else {
//             par[p1] = p2;
//             rank[p2] += rank[p1];
//         }
//         //return true bc this edge wasnt connected and now is
//         return true;
