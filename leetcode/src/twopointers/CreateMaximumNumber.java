package twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for(int i=0;i<=k;i++){
            int j = k-i;
            List<Integer> l1 = find(nums1,i);
            List<Integer> l2 = find(nums2,j);
            if((l1.size() + l2.size() != k) || l1.size()==0 ||  l2.size()==0){
                continue;
            }
            int x=0;
            int y=0;
            int[] temp = new int[k];
            int z=0;
            while(x<l1.size() || y<l2.size()){
                int n1 = x<l1.size()?l1.get(x):-1;
                int n2 = y<l2.size()?l2.get(y):-1;
                if(n1>n2){
                    temp[z++] = n1;
                    x++;
                }
                else{
                    temp[z++] = n2;
                    y++;
                }
            }
            for(int l=0;l<k;l++){
                if(ans[l]<temp[l]){
                    ans = temp;
                    break;
                }
                else if(ans[l]>temp[l]){
                    break;
                }

            }
        }
        return ans;

    }
    public List<Integer> find(int[] nums,int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>((n1,n2)->n1.num-n2.num);
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(i,nums[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<Pair> li = new ArrayList<>();
        while(!pq.isEmpty()){
            li.add(pq.poll());
        }
        Collections.sort(li,new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p2.ind - p1.ind;
            }
        });
        List<Integer> l1 = new ArrayList<>();
        for(int i=li.size()-1;i>=0;i--){
            l1.add(li.get(i).num);
        }
        return l1;
    }
    class Pair{
        int ind;
        int num;
        Pair(int ind,int num){
            this.ind = ind;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;
        int[] res = new CreateMaximumNumber().maxNumber(nums1,nums2,k);
        for(int n : res){
            System.out.print(n + " ");
        }
    }

}
