package dynamicprogramming;

public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        return predictTheWinnerUtil(nums,0,nums.length-1,0,0,true);
    }
    public boolean predictTheWinnerUtil(int[] nums,int i,int j,int s1,int s2,boolean turn){
        if(i>j){
            return s1>=s1;
        }
        if(turn){
            
            boolean ans1 = predictTheWinnerUtil(nums,i+1,j,s1+nums[i],s2,false);
            boolean ans2 = predictTheWinnerUtil(nums,i,j-1,s1+nums[j],s2,false);
            return ans1 || ans2;

        }
        else{
            boolean ans = false;
            if(nums[i]>nums[j]){
                ans = predictTheWinnerUtil(nums,i+1,j,s1,s2+nums[i],true);
            }
            else{
                ans = predictTheWinnerUtil(nums,i,j-1,s1,s2+nums[j],true);
            }
            
            return ans;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,2};
        PredictTheWinner p = new PredictTheWinner();
        System.out.println(p.predictTheWinner(arr));
    }

}
