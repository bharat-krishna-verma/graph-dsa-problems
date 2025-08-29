import java.util.HashMap;
//leetcode 2316
public class count_unreachable_pairs_of_nodes_in_undirected_graph {
    long result =0;
    long remainodes;
    private int find(int x , int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent);
    }
    private void union(int x, int y, int[] parent , int[] rank){
        int x_parent=find(x, parent);
        int y_parent=find(y, parent);
        if(x_parent==y_parent) return;
        if(rank[x_parent]>rank[y_parent]) parent[y_parent]= x_parent;
        else if(rank[x_parent]<rank[y_parent]) parent[x_parent]= y_parent;
        else{
            parent[x_parent]= y_parent;
            rank[y_parent]++;
        }
    }
     public long countPairs(int n, int[][] edges) {
        int [] parent= new int[n];
        int [] rank= new int[n];
        for(int i =0;i<n;i++)parent[i]=i;
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            union(u, v, parent, rank);
        }
        remainodes=n;
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i =0;i<n;i++){
            int currparent = find(i, parent);
            if(map.containsKey(currparent)){
                map.put(currparent,map.get(currparent)+1);
            }else{
                map.put(currparent,1);
            }
        }
        map.forEach((key,value)->{
            int size = value;
            result +=(size)*(remainodes-size);
            remainodes-=size;
        });
        return result;
     }
}
