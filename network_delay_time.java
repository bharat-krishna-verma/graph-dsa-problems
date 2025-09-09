//leetcode 743

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class network_delay_time {
    public class pair implements Comparable<pair>{
        int first,second;
        public pair(int x , int y){
            this.first=x;
            this.second=y;

        }
        public int compareTo(pair o){
            if(this.first==o.first)return this.second-o.second;
            return this.first-o.first;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k){
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++) adj.add(new ArrayList<>());
        for(int [] e : times){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new pair(w,v));
        }
        int[] dist= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(0,k));
        while(!pq.isEmpty()){
            pair curr =  pq.poll();
            int d = curr.first;
            int currnode= curr.second;
            if(d>dist[currnode]) continue;
            for(pair neigh : adj.get(currnode)){
                int wt = neigh.first;
                int nextnode = neigh.second;
                if(d+wt<dist[nextnode]){
                    dist[nextnode]= d+wt;
                    pq.offer(new pair(d+wt,nextnode));
                }
            }
        }
        int ans = 0;
        for(int i =1;i<dist.length;i++){
            if(ans==Integer.MAX_VALUE)return -1;
            ans= Math.max(ans,dist[i]);
        }
        return ans;
    }
}
