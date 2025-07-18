//LeetCode-733
import java.util.Arrays;

public class flood_fill {
  
    private void dfs(int row,int col, int [][] ans, int [][] image, int iniCol,int []dRow,int[] dCol,int color){
        ans[row][col]=color;
        int m = image.length;
        int n = image[0].length;
        for(int i =0;i<4;i++){
            int nrow= row+dRow[i];
            int ncol= col+dCol[i];
            if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&
                 image[nrow][ncol]==iniCol&&ans[nrow][ncol]!=color){
                dfs(nrow,ncol,ans,image,iniCol,dRow,dCol,color);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniCol= image[sr][sc];
        int [][] ans = Arrays.copyOf(image,image.length);
         int [] dRow={-1,0,1,0};
         int [] dCol={0,1,0,-1};
        dfs(sr,sc,ans,image,iniCol,dRow,dCol,color);
        return ans;
    }
}

