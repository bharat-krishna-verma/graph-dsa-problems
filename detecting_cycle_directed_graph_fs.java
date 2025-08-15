import java.util.ArrayList;
public class detecting_cycle_directed_graph_fs {
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean [] vis,boolean [] inRec,int start){
        vis[start]= true;
        inRec[start]= true;
        for(int curr : adj.get(start)){
            if(!vis[curr]&&dfs(adj,vis,inRec,curr)) return true;
            else if(inRec[curr]) return true;
        }
        inRec[start]= false;
        return false;
    }
    public boolean icCycle(int V,int[][]edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e: edges){
            int u =e[0];
            int v =e[1];
            adj.get(u).add(v);
        }
        boolean [] vis = new boolean[V];
        boolean [] inRec = new boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i]&&dfs(adj,vis,inRec,i));
        }
        return false;
    }
}
