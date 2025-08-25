//leetcode 1319
public class number_of_operations_to_make_network_connected_dsu {
    private int find(int x, int[] parent){
        if(parent[x]==x) return x;
        return parent[x]= find(parent[x],parent);
    }
    private void union(int x, int y, int[] parent,int[] rank){
        int x_parent= find(x,parent);
        int y_parent= find(y,parent);
        if(x_parent==y_parent) return;
        if(rank[x_parent]>rank[y_parent]) parent[y_parent]= x_parent;
        else if(rank[x_parent]<rank[y_parent]) parent[x_parent]= y_parent;
        else{
            parent[x_parent]= y_parent;
            rank[y_parent]+=1;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
         int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i =0;i<26;i++) parent[i]=i;
        int components=n;
        for(int [] e: connections){
            if(find(e[0],parent)!=find(e[1],parent)){
                union(e[0],e[1],parent,rank);
                components--;
            }
        }
        return components-1;
    }
}
