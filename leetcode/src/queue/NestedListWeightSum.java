package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList.size()==0){
            return 0;
        }
        List<int[]> ans = new ArrayList<>();
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        int dep = 1;
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                NestedInteger n = q.poll();
                max = Math.max(dep,max);
                if(n.isInteger()){
                    ans.add(new int[]{n.getInteger(),dep});
                }
                else{
                    q.addAll(n.getList());
                }
            }
            
        }
        dep++;
        int sum = 0;
        for(int i=0;i<ans.size();i++){
            sum += ans.get(i)[0]*(max-ans.get(i)[0]);
        }
        return sum;
    }
    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {}
    
        // Constructor initializes a single integer.
        public NestedInteger(int value) {}
    
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }
    
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }
    
        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {}
    
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {}
    
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        
    }

}
