package search;

public class SearchInARotatedSortedArray {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int ans = 0;
        while(l<=r){
            int m = r - (r-l)/2;
            if(nums[m]<=nums[0] && m!=0){
                ans = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        
        if(target>nums[0]){
            return find(target,nums,0,ans-1);
        }
        else{
            return find(target,nums,ans,nums.length-1);
        }
    }
    public boolean find(int t,int[] nums,int l, int r){
        while(l<=r){
            int m = (l + r) /2;
            if(nums[m]==t){
                return true;
            }
            else if(nums[m]>t){
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        SearchInARotatedSortedArray s = new SearchInARotatedSortedArray();
        System.out.println(s.search(arr, 2));
    }

}
