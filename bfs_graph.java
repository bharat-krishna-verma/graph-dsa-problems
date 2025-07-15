// We will use queue and a visited array 
//gfg question
import java.util.*;
public class bfs_graph {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis= new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int curr= q.poll();
            ans.add(curr);
            for(Integer neighbour : adj.get(curr)){
                if(vis[neighbour]==false){
                    vis[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }
        return ans; 
    }
}
