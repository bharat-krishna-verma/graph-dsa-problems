//leetcode 1584

import java.util.ArrayList;
import java.util.PriorityQueue;

public class minimum_cost_to_connect_all_points {
    public class pair implements Comparable<pair>{
        int w,v;
        public pair(int x, int y){
            this.w = x;
            this.v = y;
        }
        public int compareTo(pair o){
            return this.w-o.w;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        int n = points.length;
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                int x1= points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int d = Math.abs(x1-x2) +Math.abs(y1-y2);
                adj.get(i).add(new pair(d,j));
                adj.get(j).add(new pair(d,i));
            }
        }
        int sum =0;
        boolean [] vis= new boolean[n];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(0,0));
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int w= curr.w;
            int currnode = curr.v;
            if(vis[currnode]) continue;
            vis[currnode] = true;
            sum+=w;
            for(pair neigh : adj.get(currnode)){
                int v = neigh.v;
                int d = neigh.w;
                if(!vis[v]) pq.offer(new pair(d,v));
            }

        }
        return sum;
    }
}
