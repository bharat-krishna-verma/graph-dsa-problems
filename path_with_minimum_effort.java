//Letcode 1631

import java.util.Arrays;
import java.util.PriorityQueue;

public class path_with_minimum_effort {
    public class pair implements Comparable<pair>{
        int dist,row,col;
        public pair(int d, int x , int y){
            this.dist= d;
            this.row= x;
            this.col= y;
        }
        public int compareTo(pair o){
            return this.dist-o.dist;
        }
    }
     public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int[] rows: dist)Arrays.fill(rows,Integer.MAX_VALUE);
        dist[0][0]=0;
        int [] dx= {-1,0,0,1};
        int [] dy= {0,-1,1,0};
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.offer(new pair(0,0,0));
        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int d = curr.dist;
            int r = curr.row;
            int c = curr.col;
            if(r==m-1&&c==n-1) return d;
            for(int i =0;i<4;i++){
                int nr = r+dx[i];
                int nc = c+dy[i];
                if(nr>=0&&nr<m&&nc>=0&&nc<n){
                    int absdiff= Math.abs(heights[r][c]-heights[nr][nc]);
                    int maxdiff= Math.max(absdiff, d);
                    if(dist[nr][nc]>maxdiff){
                        dist[nr][nc]=maxdiff;
                        pq.offer(new pair(maxdiff,nr,nc));
                    }
                }
            }

        }
        return 0;
     }
}
