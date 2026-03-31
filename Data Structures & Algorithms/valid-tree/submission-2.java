class Solution {
    int[] parent;
    int[] rank;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for(int i =0; i<n ; i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            if(!union(edge[0],edge[1])){
                return false;
            }
        }
        return true;


    }
    boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX==parentY){
            return false;
        }
        if(rank[parentX]>rank[parentY]){
            parent[parentY] = parentX;
            rank[parentX] = rank[parentX] + rank[parentY];
        } else {
            parent[parentX] = parentY;
            rank[parentY] = rank[parentX] + rank[parentY];;

        }
        return true;
        

    }
    int find(int x){
        if(parent[x]!=x){
            return find(parent[x]);
        }
        return x;
         
    }
}
