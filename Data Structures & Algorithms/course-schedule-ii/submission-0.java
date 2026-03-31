class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }
        for(int i =0; i<numCourses; i++){
            if(!dfs(i, adjList, visited, ans)){
                return new int[]{};
            }
        }
        int[] res = new int[ans.size()];
        for(int i =0; i<ans.size();i++){
            res[i]=ans.get(i); 
        }
        return res;
        
    }

    boolean dfs(int course, List<List<Integer>> adjList ,int[] visited, List<Integer> courseOrder){
        if(visited[course]==-1){
            return false;
        }
        if(visited[course]==1){
            return true;
        }
        visited[course] = -1;
        for(int nextCourse: adjList.get(course)){
            if(!dfs(nextCourse, adjList, visited, courseOrder)){
                return false;
            }
        }
        courseOrder.add(course);
        visited[course] = 1;
        return true;
    }
}
