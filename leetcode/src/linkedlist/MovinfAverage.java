package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

class MovinfAverage {
    Queue<Integer> q;
    int size;
    int sum;
    public MovinfAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(q.size()==size){
            sum-=q.poll();
        }
        q.add(val);
        sum+=val;
        double av = q.size()==0? (double)sum : (double)sum/(double)q.size();
        return av;
    }
    public static void main(String[] args) {
        MovinfAverage m = new MovinfAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
