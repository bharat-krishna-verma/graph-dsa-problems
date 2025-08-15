//LeetCode- 547
//We are given a adjacency matrix , we can solve it either by creating adjacency list of by 
//adjacenecy matrix itself , traversal can be any -bfs-dfs
import java.util.*;
public class number_of_provinces {
    //using dfs
    private void dfs(int[][]isConnected,int node,boolean [] vis){
        vis[node] =true;
        for(int i =0;i<isConnected.length;i++){
            if(isConnected[node][i]==1&&(!vis[i])){
                    dfs(isConnected, i, vis);
            }
        }
    }
    public int question(int[][] isConnected){
        int n = isConnected.length;
        boolean [] vis = new boolean[n];
        int count =0;
        for(int i =0;i<n ;i++){
            if(!vis[i]){
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }
//using bfs
public void bfs(int[][] isConnected,boolean [] vis,int start){
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    vis[start]= true;
    while(!q.isEmpty()){
        int curr = q.poll();
        for(int i =0;i<isConnected.length;i++){
            if(isConnected[curr][i]==1&&!vis[i]){
                vis[i]=true;
                q.offer(i);
            }
        }
    }
}
 public int questionBFS(int[][] isConnected){
    int count =0;
    int n = isConnected.length;
    boolean [] vis = new boolean[n];
    for(int i =0;i<n;i++){
        if(!vis[i]){
            bfs(isConnected,vis,i);
            count++;
        }
    }
    return count;
 }
}