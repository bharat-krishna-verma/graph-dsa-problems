//gfg problem
import java.util.ArrayList;
import java.util.Stack;

public class topological_sort {
    private void dfs(ArrayList<ArrayList<Integer>> adj,boolean [] vis,int start,Stack<Integer> st){
        vis[start]= true;
        for(int curr : adj.get(start)){
            if(!vis[curr]){
                dfs(adj,vis,curr,st);
            }
        }
        st.push(start);
    }
    public ArrayList<Integer> topo(int V,int [][] edges){
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e: edges){
            int u =e[0];
            int v =e[1];
            adj.get(u).add(v);
        }
        boolean [] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<V;i++){
            if(!vis[i]){
                dfs(adj,vis,i,st);
            }
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}
