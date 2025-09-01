import java.util.*;


public class dijkstra_algo_set {
    class pair implements Comparable<pair>{
        int first,second;
        public pair(int x, int y){
            this.first=x;
            this.second=y;
        }
        public int compareTo(pair o){
            if(this.first==o.first) return this.second-o.second;
            return this.first-o.first;
        }

    }
       public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i =0;i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new pair(w,v));
            adj.get(v).add(new pair(w,u));
        }
        int [] result= new int[V];
        Arrays.fill(result,Integer.MAX_VALUE);
        TreeSet<pair> st = new TreeSet<>();
        result[src]=0;
        st.add(new pair(0,src));
        while(!st.isEmpty()){
            pair temp = st.pollFirst();
            int d = temp.first;
            int node = temp.second;
            for(pair neigh : adj.get(node)){
                int wt = neigh.first;
                int adjnode = neigh.second;
                if(d+wt<result[adjnode]){
                    if(result[adjnode]!=Integer.MAX_VALUE){
                        st.remove(new pair(result[adjnode],adjnode));
                    }
                    result[adjnode]= d+wt;
                    st.add(new pair(d+wt, adjnode));
                }
            }
        }
        return result;
       }
}
