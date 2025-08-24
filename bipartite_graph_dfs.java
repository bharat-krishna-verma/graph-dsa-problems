//gfg problem 
import java.util.ArrayList;
public class bipartite_graph_dfs {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] color,int curr,int currcolor){
        color[curr]= currcolor;
        for(int v : adj.get(curr)){
            if(color[v]==color[curr])return false;
            if(color[v]==-1){
                color[v]= 1-currcolor;
                if(!dfs(adj,color,v,color[v]))return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i =0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            for(int [] e: edges){
                int u = e[0];
                int v = e[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            //red = 1
            //green = 0
            int[] color= new int[V];
            for(int i =0;i<V;i++){
                color[i]=-1;
            }
            for(int i =0;i<V;i++){
                if(color[i]==-1){
                    if(!dfs(adj,color,i,1)) return false;
                }
            }
            return true;
      }
}