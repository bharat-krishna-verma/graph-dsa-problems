import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detecting_cycle_undirected_graph_bfs {
    static class pair{
        int node;
        int parent;
        pair(int x,int y){
            this.node= x;
            this.parent= y;
        }
    }
    private boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis, int start){
        vis[start]= true;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(start,-1));
        while(!q.isEmpty()){
            pair temp = q.poll();
            int curr =temp.node;
            int parent =temp.parent;
            for(int e : adj.get(curr)){
                if(!vis[e]){
                    vis[e]= true;
                    q.offer(new pair(e,curr));

                }
                else if(e!=parent)return true;
            }
        }
        return false;
    }
    //edge list is given 
    public boolean isCycle(int V, int[][] edges){
        //converting edges lit to adjacenecy list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for(int i =0;i<V;i++){
            if(!vis[i]&& bfs(adj,vis,i)) return true;
        }
        return false;
    }
}
