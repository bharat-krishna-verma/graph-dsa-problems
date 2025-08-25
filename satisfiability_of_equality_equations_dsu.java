//leetcode - 990
public class satisfiability_of_equality_equations_dsu {
    private int find(int x, int[] parent){
        if(parent[x]==x) return x;
        return parent[x]= find(parent[x],parent);
    }
    private void union(int x, int y, int[] parent,int[] rank){
        int x_parent= find(x,parent);
        int y_parent= find(y,parent);
        if(x_parent==y_parent) return;
        if(rank[x_parent]>rank[y_parent]) parent[y_parent]= x_parent;
        else if(rank[x_parent]<rank[y_parent]) parent[x_parent]= y_parent;
        else{
            parent[x_parent]= y_parent;
            rank[y_parent]+=1;
        }
    }
    public boolean equationsPossible(String[] equations){
        int[] parent = new int[26];
        int[] rank = new int[26];
        for(int i =0;i<26;i++) parent[i]=i;
        for(String s: equations){
            if(s.charAt(1)=='='){
                union(s.charAt(0)-'a',s.charAt(3)-'a',parent,rank);
            }
        }
        for(String s : equations){
            if(s.charAt(1)=='!'){
                char first = s.charAt(0);
                char second = s.charAt(3);
                int first_parent = find(first-'a',parent);
                int second_parent = find(second-'a',parent);
                if(first_parent==second_parent) return false;
            }
        }
        return true;
    }
}
