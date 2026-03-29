package contest;

public class SumOfSortableIntegers {
    public int sortableIntegers(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        boolean flag = true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                flag = false;
                break;
            }
        }
        int sum = 0;
        for(int i=2;i<=nums.length;i++){
            if(nums.length%i==0){
                if(flag){
                    sum += i;
                    continue;
                }
                if(check(nums,i)){
                    sum += i;
                }
            }
        }
        return sum;
    }
    public boolean check(int[] nums, int k){
        int ind=0;
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                count++;
            }
            if(ind==k-1){
                if(count>1){
                    return false;
                }
                ind=0;
                count=0;
            }
            ind++;
        }
        return count<=1;
    }
    public static void main(String[] args) {
        int[] nums = {7,6,5};
        System.out.println(new SumOfSortableIntegers().sortableIntegers(nums));
    }

}
