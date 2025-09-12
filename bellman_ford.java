import java.util.Arrays;
//gfg problem 
public class bellman_ford {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int [] res = new int[V];
        int INF = (int)1e8;
        Arrays.fill(res,INF);
        res[src]=0;
        for(int i =1;i<V-1;i++){
            for(int [] e: edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if(res[u]!=INF&&res[u]+w<res[v]){
                    res[v]=res[u]+w;
                }
            }
        }
         for(int [] e: edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if(res[u]!=INF&&res[u]+w<res[v]){
                    return new int[]{-1};
                }
            }
        return res;

    }
}
