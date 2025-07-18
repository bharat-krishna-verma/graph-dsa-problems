//gfg question
import java.util.*;
public class dfs_graph {
    private void helper(ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node){
        vis[node]= true;
        ans.add(node);
        for(Integer curr: adj.get(node)){
            if(!vis[curr]){
                helper(ans, adj, vis, curr);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj ){
        int n = adj.size();
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        int start =0;
        helper(ans, adj, vis, start);
        return ans;
    }
}
