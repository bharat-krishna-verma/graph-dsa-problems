//LeetCode-994
import java.util.LinkedList;
import java.util.Queue;

public class rotting_oranges {
  
    private class Pair{
        int row,col,time;
        private Pair(int x,int y,int z){
            this.row = x;
            this.col = y;
            this.time = z;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m =grid.length;
        int n =grid[0].length;
        int freshcnt =0;
        Queue<Pair> q= new LinkedList<>();
        int [][] vis = new int [m][n];
        for(int i =0;i<m ;i++){
            for(int j =0;j<n ;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }
        int cnt=0;
        int tm =0;
        int[] drow={0,0,-1,1};
        int[] dcol={-1,1,0,0};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();
            tm= Math.max(tm,t);
            for(int i =0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]!=2&&grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=freshcnt) return -1;
        return tm;
    }
}   