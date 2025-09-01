import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra_algo_heap {
    class pair implements Comparable<pair>{
        int first,second;
        public pair(int x, int y){
            this.first=x;
            this.second=y;
        }
        public int compareTo(pair o){
            return this.first-o.first;
        }
    }
     public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e: edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new pair(w,v));
        }
        PriorityQueue<pair> pq= new PriorityQueue<>();
        int [] result =new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src]= 0;
        pq.offer(new pair(0,src));
        while(!pq.isEmpty()){
            pair temp = pq.poll();
            int d = temp.first;
            int node = temp.second;
            if(d>result[node])continue;
            for(pair neigh: adj.get(node)){
                int wt = neigh.first;
                int adjnode =neigh.second;
                if(d+wt<result[adjnode]){
                    result[adjnode]= d+wt;
                    pq.offer(new pair(d+wt, adjnode));
                }
            }
        }
        return result;
     }
}
