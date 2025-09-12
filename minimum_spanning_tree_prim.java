import java.util.ArrayList;
import java.util.PriorityQueue;

public class minimum_spanning_tree_prim {
    public class pair implements Comparable<pair>{
        int weight,node;
        public pair(int x, int y){
            this.weight=x;
            this.node=y;
        }
        public int compareTo(pair o){
            return this.weight-o.weight;
        }
    }
     public int spanningTree(int V, int[][] edges){
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i =0;i<V;i++) adj.add(new ArrayList<>());
        for(int [] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new pair(w,v));
            adj.get(v).add(new pair(w,u));
        }
        int sum =0;
        boolean [] vis= new boolean[V];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(0,0));
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int w= curr.weight;
            int currnode = curr.node;
            if(vis[currnode]) continue;
             vis[currnode] = true;
            sum+=w;
            for(pair neigh : adj.get(currnode)){
                int v = neigh.node;
                int d = neigh.weight;
                if(!vis[v]) pq.offer(new pair(d,v));
            }

        }
        return sum;
     }
}
