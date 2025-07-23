package string;

public class AddString {
    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            int n1 = num1.charAt(i)-'0';
            int n2 = num2.charAt(j)-'0';
            int sum = (n1+n2+carry)%10;
            carry = (n1+n2+carry)/10;
            sb.append(sum);
            i--;
            j--;
        }
        while(i>=0){
            int n1 = num1.charAt(i)-'0';
            int sum = (n1+carry)%10;
            carry = (n1+carry)/10;
            sb.append(sum);
            i--;
        }
        while(j>=0){
            int n2 = num2.charAt(j)-'0';
            int sum = (n2+carry)%10;
            carry = (n2+carry)/10;
            sb.append(sum);
            j--;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }

}
