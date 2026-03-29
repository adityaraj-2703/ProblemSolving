package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TheMaze3 {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] d = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(d[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Pair a,Pair b){
                if(a.count==b.count){
                    return a.path.compareTo(b.path);
                }
                return a.count - b.count;
            }
        });
        pq.add(new Pair(ball[0],ball[1],0,new StringBuilder()));
        d[ball[0]][ball[1]] = 0;
        int[] dirX = {0,0,1,-1};
        int[] dirY = {1,-1,0,0};
        Map<Integer,Character> hm = new HashMap<>();
        String ans = "";
        hm.put(0,'r');
        hm.put(1,'l');
        hm.put(2,'d');
        hm.put(3,'u');
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int i=0;i<4;i++){
                int nX = p.x;
                int nY = p.y;
                int count = 0;
                while(nX>=0 && nX<m && nY>=0 && nY<n && maze[nX][nY]==0){
                    nX += dirX[i];
                    nY += dirY[i];
                    count++;
                    if(hole[0]==nX && hole[1]==nY){
                        break;
                    }
                }
                if(hole[0]==nX && hole[1]==nY){
                    if(d[hole[0]][hole[1]]>d[p.x][p.y]+count){
                        d[hole[0]][hole[1]] = d[p.x][p.y]+count;
                        ans = p.path.append(hm.get(i)).toString();
                    }
                    continue;
                }
                nX-=dirX[i];
                nY-=dirY[i];
                if(d[nX][nY]>d[p.x][p.y]+count){
                    d[nX][nY] = d[p.x][p.y]+count;
                    pq.add(new Pair(nX,nY,d[nX][nY],p.path.append(hm.get(i))));
                }
            }
        }
        return ans.length()==0?"impossible":ans;

    }
    class Pair{
        int x;
        int y;
        int count;
        StringBuilder path;
        Pair(int x,int y,int count,StringBuilder path){
            this.x =x;
            this.y = y;
            this.count = count;
            this.path = path;
        }
    }
    public static void main(String[] args) {
        TheMaze3 t = new TheMaze3();
        System.out.println(t.findShortestWay(new int[][]{{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}}, new int[]{4,3}, new int[]{0,1}));
    }

}
