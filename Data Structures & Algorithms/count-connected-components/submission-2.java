class Solution {
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i =0;i<n;i++){
            parent[i]=i;
        }
        rank = new int[n];
        Arrays.fill(rank,1);
        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }
        int comp = 0;
        for(int i =0; i<n; i++){
            if(parent[i]==i){
                comp++;

            }
        }
        return comp;

    }
    void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if(parentX==parentY){
            return;
        }
        if(rank[parentX]>rank[parentY]){
            parent[parentY] = parentX;
            rank[parentX]++;
        } else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        } else {
            return parent[x];
        }
    }
}
