class Solution {
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        rank = new int[edges.length+1];
        Arrays.fill(rank, 1);
        parent = new int[edges.length+1];
        for(int i =1; i<edges.length; i++){
            parent[i]=i;

        }
        int[] res = new int[] {0,0};
        for(int[]edge: edges){
            if(!union(edge[0], edge[1])){
                res = edge;
            }
        }
        return res; 
    }
    boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX==parentY){
            return false;
        }
        if(rank[parentX]>rank[parentY]){
            parent[parentY] = parentX;
        } else if(rank[parentX]<rank[parentY]){
            parent[parentX] = parentY;
        } else{
            parent[parentY] = parentX;
            rank[parentX]++;
        }
        return true;
    }
    int find(int x){
        if(parent[x]!=x){
            return find(parent[x]);
        } return x;
    }
}
