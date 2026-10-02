class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjlist= new HashMap<>(); 
        // 1 is still exploring, we are still looking at its prereqs, and prereqs of that
        // 2 is done exploring, we have reached end of prereqs for them
        int[] state = new int[numCourses];


        // create adjacency list
        for (int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            
            adjlist.putIfAbsent(course, new ArrayList<>());
            adjlist.get(course).add(prereq);
        }

        for (int course = 0; course < numCourses; course++) {
            if (detectCycle(course, adjlist, state)) {
                return false;
            }
        }
        return true;
        
    }

    private boolean detectCycle( int course, HashMap<Integer, List<Integer>> adjlist, 
    int[] state) {
        // we are going to look for if we reach the course again while exploring it
        //it means theres a cycle, if we have already finished exploring this course
        // it means we can just skip, its a seperate line, and if we get 0, first time 
        //exploring


        if (state[course] == 1) return true;
        if (state[course] == 2) return false;
        
        state[course] = 1;
        if(adjlist.containsKey(course)){
            for ( int prereq : adjlist.get(course)){
                if (detectCycle(prereq, adjlist, state)) return true;
            }
        }
        state[course] = 2;
        return false;
    }

    // private boolean hasCycle(
    //     int course,
    //     HashMap<Integer, List<Integer>> adjlist,
    //     int[] state
    // ) {
    //     // Currently exploring this course → cycle
    //     if (state[course] == 1) {
    //         return true;
    //     }

    //     // Already completely explored → no need to explore again
    //     if (state[course] == 2) {
    //         return false;
    //     }

    //     // Mark as currently exploring
    //     state[course] = 1;

    //     // Explore all prerequisites
    //     if (adjlist.containsKey(course)) {
    //         for (int prereq : adjlist.get(course)) {
    //             if (hasCycle(prereq, adjlist, state)) {
    //                 return true;
    //             }
    //         }
    //     }

    //     // Finished exploring this course
    //     state[course] = 2;

    //     return false;
    // }
}
