
//gfg question
import java.util.ArrayList;

public class detecting_cycle_undirected_graph_dfs {
    private boolean dfs( boolean[] vis, ArrayList<ArrayList<Integer>> adj,int start,int parent){
        vis[start]= true;
        for(int curr : adj.get(start)){
            if(curr==parent) continue;
            if(vis[curr]) return true;
            if(dfs(vis,adj,curr,start)) return true;

        }
        return false;
    }
    //edge list is given 
    public boolean isCycle(int v, int[][] edges){
        //converting edges lit to adjacenecy list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[v];
        for(int i =0;i<v;i++){
            if(!vis[i]&& dfs(vis,adj,i,-1)) return true;
        }
        return false;
    }
}
