import java.util.*;
public class kahns_aldo_topological_sort_bfs {
    public static ArrayList<Integer> topo(int V, int [][] edges){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<V ;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e: edges){
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
        for(int i =0;i<V;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr =q.poll();
            ans.add(curr);
            for(int v : adj.get(curr)){
                inDegree[v]--;
                if(inDegree[v]==0) q.offer(v);
            }
        }
        return ans;
    }
}
