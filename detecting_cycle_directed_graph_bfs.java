import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class detecting_cycle_directed_graph_bfs {
    //using kahns algorithm 
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        int [] inDegree = new int[V];
        for(int i =0;i<V;i++){
            for(int v : adj.get(i)){
                inDegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        for(int i =0;i<V;i++){
            if(inDegree[i]==0) {
                q.offer(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int t : adj.get(curr)){
                inDegree[t]--;
                if(inDegree[t]==0) {
                    q.offer(t);
                   count++;
                }
            }
        }
        return count!=V; 
    }
}