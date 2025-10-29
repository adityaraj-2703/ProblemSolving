package queue;

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> max = new PriorityQueue<>((n1,n2)->n2.val-n1.val);
        PriorityQueue<Pair> min = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        for(int i=0;i<k;i++){
            if(max.size()==0){
                max.add(new Pair(nums[i],i));
            }
            else if(min.size()==0){
                if(nums[i]>=max.peek().val){
                    min.add(new Pair(nums[i],i));
                }
                else{
                    min.add(max.poll());
                    max.add(new Pair(nums[i],i));
                }
            }
            else{
                if(max.size()==min.size()){
                    if(nums[i]>min.peek().val){
                        max.add(min.poll());
                        min.add(new Pair(nums[i],i));
                    }
                    else{
                        max.add(new Pair(nums[i],i));
                    }
                }
                else if(max.size()>min.size()){
                    if(nums[i]>max.peek().val){
                        min.add(new Pair(nums[i],i));
                    }
                    else{
                        Pair temp = max.peek();
                        max.poll();
                        min.add(temp);
                        max.add(new Pair(nums[i],i));
                    }
                }
            }
        }
        int n = nums.length;
        double[] ans = new double[n-k+1];
        int ind = 1;
        ans[0] = k%2!=0?(double)(max.peek().val):(double)((max.peek().val + min.peek().val)/2.0);
        for(int i=k;i<nums.length;i++){
            if(max.peek().ind == ind-1){
                max.poll();
            }
            else if(min.peek().ind == ind-1){
                min.poll();
            }
            if(max.size()==0){
                max.add(new Pair(nums[i],i));
            }
            else if(min.size()==0){
                if(nums[i]>=max.peek().val){
                    min.add(new Pair(nums[i],i));
                }
                else{
                    min.add(max.poll());
                    max.add(new Pair(nums[i],i));
                }
            }
            else{
                if(max.size()==min.size()){
                    if(nums[i]>min.peek().val){
                        max.add(min.poll());
                        min.add(new Pair(nums[i],i));
                    }
                    else{
                        max.add(new Pair(nums[i],i));
                    }
                }
                else if(max.size()>min.size()){
                    if(nums[i]>max.peek().val){
                        min.add(new Pair(nums[i],i));
                    }
                    else{
                        Pair temp = max.peek();
                        max.poll();
                        min.add(temp);
                        max.add(new Pair(nums[i],i));
                    }
                }
            }
            ans[ind++] =  k%2!=0?(double)(max.peek().val):(double)((max.peek().val + min.peek().val)/2.0);

        }
        return ans;


    }
    class Pair{
        int val;
        int ind;
        Pair(int val,int ind){
            this.val = val;
            this.ind = ind;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] ans = new SlidingWindowMedian().medianSlidingWindow(nums,k);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }

}
