//leetcode 785
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartite_graph_bfs {
    
    public boolean bfs(int[][]graph,int [] color,int curr){
        Queue<Integer> q =new LinkedList<>();
        q.offer(curr);
        color[curr]= 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int v : graph[node]){
                if(color[node]==color[v]) return false;
                else if(color[v]==-1){
                    color[v]= 1-color[node];
                    q.offer(v);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] color= new int[n];
        Arrays.fill(color,-1);
       for(int i =0;i<n;i++){
        if(color[i]==-1){
            if(!bfs(graph,color,i))return false;
        }
       }
       return true;
    }
}