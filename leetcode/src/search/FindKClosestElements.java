package search;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr.length<=k){
            List<Integer> ans  = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        List<Integer> ans1  = new ArrayList<>();
        int l = 0;
        int r = arr.length-1;
        int ans = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(arr[m]<=x){
                ans = m;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        int left = ans;
        int right = ans;
        while(right-left < k){
            if(left<0){
                right+=1;
                continue;
            }
            if(right==arr.length){
                left--;
                continue;
            }
            if(Math.abs(x-arr[left]) < Math.abs(x-arr[right]) ){
                left--;
            }
            else{
                right++;
            }
        }

        
        for(int i=left;i<right;i++){
            if(arr[i]!=x){
                ans1.add(arr[i]);
                
            } 
              
            
        }
        return ans1;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 5;
        int x = 4;
        System.out.println(new FindKClosestElements().findClosestElements(arr, k, x));
    }

}
