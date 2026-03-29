package noclue;

public class FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max+1];
        int[] count = new int[max+1];
        arr[1] = 1;
        for(int i=2;i<=max/2;i++){
            arr[i]+=i;
            for(int j=i*2;j<=max;j+=i){
                arr[j]+=i;
                count[j]++;
            }
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(count[nums[i]]==2){
                sum += arr[nums[i]] + nums[i] + 1;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {21,4,7};
        int res = new FourDivisors().sumFourDivisors(nums);
        System.out.println(res);
    }
}
