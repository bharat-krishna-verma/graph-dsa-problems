//LeetCode-200
import java.util.*;
public class number_of_islands {
    class pair{
        int row,col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private void bfs(int startRow,int startCol,char[][] grid,boolean[][] vis){
        vis[startRow][startCol]= true;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(startRow,startCol));
        int[] dRow={-1,1,0,0};
        int[] dCol={0,0,-1,1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            for(int i =0;i<4;i++){
                int nRow= r+dRow[i];
                int nCol= c+dCol[i];
                if(nRow>=0&&nRow<grid.length&&nCol>=0&&nCol<grid[0].length&&grid[nRow][nCol]=='1'&&!vis[nRow][nCol]){
                    vis[nRow][nCol]=true;
                    q.offer(new pair(nRow,nCol));
                }
            }
        }
    }
    public int numIslands(char [][] grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count =0;
        for(int row = 0;row<m;row++){
            for(int col =0;col<n;col++){
                if(grid[row][col]=='1'&&!vis[row][col]){
                    count++;
                    bfs(row,col,grid,vis);
                }
            }
        }
        return count;

    }
}
