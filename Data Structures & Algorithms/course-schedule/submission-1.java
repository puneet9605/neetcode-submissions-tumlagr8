class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites ){
            adj.get(pre[1]).add(pre[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(visited[i]!=1){
                if(dfs(i, adj, visited)==false){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int node, List<List<Integer>> adj, int[]visited){
        if(visited[node] == -1){
            return false;
        }
        if(visited[node] == 1){
            return true;
        }
        visited[node] = -1;
        List<Integer> preq = adj.get(node);
        for(int course: preq){
             if (!dfs(course, adj, visited)) {
                return false;
    }
        }
        visited[node] = 1;
        return true;
    }
}
