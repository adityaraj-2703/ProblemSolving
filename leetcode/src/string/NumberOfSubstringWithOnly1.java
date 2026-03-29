package string;

public class NumberOfSubstringWithOnly1 {
    public int numSub(String s) {
        int i=0;
        int j=0;
        int sum =0;
        while(j<s.length()){
            if(s.charAt(j)=='1'){
                sum += j-i+1;
                j++;
            }
            else{
                j++;
                i = j;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        NumberOfSubstringWithOnly1 n = new NumberOfSubstringWithOnly1();
        String s = "111111";
        System.out.println(n.numSub(s));
    }

}
