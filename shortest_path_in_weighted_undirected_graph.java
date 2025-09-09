//gfg problem
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
public class shortest_path_in_weighted_undirected_graph {
    public class pair implements Comparable<pair>{
        int first,second;
        public pair(int x, int y){
            this.first=x;
            this.second=y;
        }
        public int compareTo(pair o){
            if(this.first==o.first) return this.second-o.second;
            return this.first-o.first;
        }
    }
     public List<Integer> shortestPath(int n, int m, int edges[][]){
            ArrayList<ArrayList<pair>> adj = new ArrayList<>();
            for(int i= 0;i<=n;i++){
                adj.add(new ArrayList<>());
            }
            for(int [] e: edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                adj.get(u).add(new pair(w, v));
                adj.get(v).add(new pair(w, u));
            }
            int [] dist = new int[n+1];
            int [] parent = new int[n+1];
            for(int i =1;i<=n;i++) parent[i]=i;
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[1]=0;
            PriorityQueue<pair> pq = new PriorityQueue<>();
            pq.offer(new pair(0,1));
            while(!pq.isEmpty()){
                pair curr = pq.poll();
                int d = curr.first;
                int currnode = curr.second;
                for(pair neigh : adj.get(currnode)){
                    int wt = neigh.first;
                    int nextnode = neigh.second;
                    if(d+wt<dist[nextnode]){
                        dist[nextnode]= d+wt;
                        parent[nextnode]= currnode;
                        pq.offer(new pair(d+wt,nextnode));
                    }
                }
            }
            if(dist[n]==Integer.MAX_VALUE) return Arrays.asList(-1);
            int node = n;
            ArrayList<Integer> ans = new ArrayList<>();
            while(parent[node]!=node){
                ans.add(node);
                node = parent[node];
            }
            ans.add(1);
            ans.add(dist[n]);
            Collections.reverse(ans);
            return ans;
     }
}
