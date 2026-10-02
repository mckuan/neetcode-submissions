class Solution {
    int i = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjlist = new HashMap<>();
        int[] res = new int[numCourses];
        int[] state = new int[numCourses];
        //same as one, everybody starts out as 0,
        // 1 is still exploring, 2 is done w exploring
        

        for (int[]pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            adjlist.putIfAbsent(course, new ArrayList<>());
            adjlist.get(course).add(prereq);
        }

        for (int course = 0; course < numCourses; course++){
            if (createSchedule(res, state, adjlist, course)){
                return new int[0];
            }
        }
        return res;
        
    }

    private  boolean createSchedule(int[] res, int[] state, 
    HashMap<Integer, List<Integer>> adjlist, int course){

        if (state[course] == 1) return true;
        if (state[course] == 2) return false;

        state[course] = 1;
        if (adjlist.containsKey(course)){
            for (int prereq : adjlist.get(course)){ 
                if (createSchedule(res, state, adjlist, prereq)) return false;
            }
        }

        state[course] = 2;
        res[i] = course;
        i++;
        return false;
    }
}
