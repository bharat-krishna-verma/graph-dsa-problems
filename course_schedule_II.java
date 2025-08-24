//LeetCode-210
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class course_schedule_II {
     public int[] findOrder(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : prerequisites){
            int u =e[0];
            int v =e[1];
            adj.get(v).add(u);
        }
        int [] inDegree= new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int e : adj.get(i)){
                inDegree[e]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int count =0;
        for(int i =0;i<numCourses;i++){
            if(inDegree[i]==0){
                ans.add(i);
                q.offer(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int curr=q.poll();
            for(int t : adj.get(curr)){
                inDegree[t]--;
                if(inDegree[t]==0){
                    ans.add(t);
                    count++;
                    q.offer(t);
                }
            }
        }
        if(numCourses==count){
            int[] res= new int[numCourses];
            for(int i =0;i<numCourses;i++){
                res[i]= ans.get(i);
            }
            return res;
        }
        return new int [0];
     }
}
