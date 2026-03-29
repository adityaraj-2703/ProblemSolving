package bitwise;

public class NumberOfStepsToReduceNumberTo1 {
    public int numSteps(String s) {
        int count = 0;
        while(s.length()!=1){
            if(s.charAt(s.length()-1)=='1'){
                s = add(s);
            }
            else{
                s = shift(s);
            }
            count++;
        }
        return count;
    }
    public String shift(String s){
        return s.substring(0,s.length()-1);
    }
    public String add(String s){
        StringBuilder sb = new StringBuilder();
        int i=s.length()-2;
        char carry = '0';
        if(s.charAt(s.length()-1)=='1'){
            carry = '1';
            sb.append('0');
        }
        else{
            sb.append(s.charAt(s.length()-1));
        }
        while(i>=0){
            if(carry=='1' && s.charAt(i)=='1'){
                carry = '1';
                sb.append('0');
            }
            else{
                sb.append(s.charAt(i));
                carry = '0';
            }
            i--;
        }
        if(carry=='1'){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        NumberOfStepsToReduceNumberTo1 obj = new NumberOfStepsToReduceNumberTo1();
        System.out.println(obj.numSteps("11001"));
    }

}
