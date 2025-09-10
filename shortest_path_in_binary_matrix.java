//leetcode 1091
import java.util.Arrays;
import java.util.PriorityQueue;

public class shortest_path_in_binary_matrix {
    public class pair implements Comparable<pair>{
        int dist,row,col;
        public pair(int d,int x, int y){
            this.dist=d;
            this.row=x;
            this.col=y;
        }
        public int compareTo(pair o){
            return this.dist-o.dist;
        }
    }
     public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if(grid[0][0]==1||grid[n-1][n-1]==1) return -1;
            int [][] dist = new int [n][n];
            for(int [] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
            dist[0][0]=1;
            int[] dx ={-1,-1,-1,0,0,1,1,1};
            int[] dy ={-1,0,1,-1,1,-1,0,1};
            PriorityQueue<pair> pq = new PriorityQueue<>();
            pq.offer(new pair(1,0,0));
            while(!pq.isEmpty()){
                pair curr = pq.poll();
                int d= curr.dist;
                int r = curr.row;
                int c = curr.col;
                if(r==n-1&&c==n-1) return d;
                for(int i =0;i<8;i++){
                    int nr = r+dx[i];
                    int nc = c+dy[i];
                    if(nr>=0&&nr<8&&nc>=0&&nc<8&&grid[nr][nc]==0){
                        if(d+1<dist[nr][nc]){
                            dist[nr][nc]=d+1;
                            pq.offer(new pair(d+1,nr,nc));
                        }
                    }
                }
            }
            return -1;
     }
}
