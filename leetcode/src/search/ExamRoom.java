package search;

import java.util.ArrayList;
import java.util.List;

public class  ExamRoom {
    
    List<Integer> li;
    int n;
    public ExamRoom(int n) {
        li = new ArrayList<>();
        this.n = n;
    }
    
    public int seat() {
        if(li.size()==0){
            li.add(0);
            return 0;
        }
        if(li.size()==1 && li.get(0)==0){
            li.add(n-1);
            return n-1;
        }
        int start = -1;
        int i=0;
        int max = 0;
        int ans = -1;
        int ind = -1;
        while(i<li.size()){
            int end = li.get(i);
            if((end-start) / 2 > max){
                max = (end-start)/2;
                ind = i;
                ans = start + max;
            }
            start = li.get(i);
            i++;
        }
        if(ans!=-1){
            li.add(ind,ans);
        }
        return ans;
        
    }
    
    public void leave(int p) {
        for(int i=0;i<li.size();i++){
            if(li.get(i)==p){
                li.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        ExamRoom er = new ExamRoom(10);
        System.out.println(er.seat()); // 0
        System.out.println(er.seat()); // 9
        System.out.println(er.seat()); // 4
        er.leave(4);
        System.out.println(er.seat()); // 5
        er.leave(0);
        System.out.println(er.seat()); // 1
    }
}