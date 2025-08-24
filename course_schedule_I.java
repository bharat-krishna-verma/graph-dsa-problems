//LeetCode-207
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class course_schedule_I {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e : prerequisites){
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
        }
        int[] inDegree= new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int e : adj.get(i)){
                inDegree[e]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        for(int i =0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int t : adj.get(curr)){
                inDegree[t]--;
                if(inDegree[t]==0){
                    q.offer(t);
                    count++;
                }
            }
        }
        return numCourses==count;
    }
}
    