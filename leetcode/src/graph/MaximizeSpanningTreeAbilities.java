package graph;

import java.util.Arrays;
import java.util.Comparator;

public class MaximizeSpanningTreeAbilities {
    public int maxStability(int n, int[][] edges, int k) {
        Arrays.sort(edges,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[3]!=b[3]){
                    return b[3]-a[3];
                }
                else{
                    return b[2]-a[2];
                }
            }
        });
        int[] parent = new int[n];
        int[] size = new int[n];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        for(int i=0;i<parent.length;i++){
            size[i] = 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++){
            int t1 = find(edges[i][0],parent);
            int t2 = find(edges[i][1],parent);
            if(t1!=t2){
                if(edges[i][3]==1){
                    int temp = edges[i][2]*2;
                    min = Math.min(min,temp);
                }
                else{
                    int temp = edges[i][2];
                    min = Math.min(min,temp);
                }
            }
            union(t1,t2,parent,size);
        }
        return min;
    }
    public int find(int x,int[] parent){
        if(x==parent[x]){
            return x;
        }
        parent[x] = find(parent[x],parent);
        return parent[x];
    }
    public void union(int x,int y,int[] parent,int[] size){
        if(size[x]>size[y]){
            parent[y] = x;
            size[x]+=size[y];
        }
        else if(size[y]>size[x]){
            parent[x] = y;
            size[y]+=size[x];
        }
        else{
            parent[x] = y;
            size[y]+=size[x];
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,4,0},{1,2,3,0},{0,2,1,0}};
        int k = 2;
        MaximizeSpanningTreeAbilities m = new MaximizeSpanningTreeAbilities();
        System.out.println(m.maxStability(3, edges, k));
    }

}
