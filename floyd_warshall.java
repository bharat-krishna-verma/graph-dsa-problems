public class floyd_warshall {
    public void floydWarshall(int[][] dist){
        int INF =(int)1e8;
        int n = dist.length;
        for(int via =0;via<n;via++){
            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){
                if(dist[i][via]!=INF&&dist[via][j]!=INF)
                dist[i][j]= Math.min(dist[i][j],dist[i][via]+dist[via][j]);
             }
          }
        }
    }
}
