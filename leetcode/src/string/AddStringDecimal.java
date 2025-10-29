package string;

public class AddStringDecimal {
    public static String addStringDecimal(String s1, String s2) {

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        StringBuilder d1 = new StringBuilder();
        StringBuilder d2 = new StringBuilder();
        while (s1.charAt(i) != '.') {
            d1.append(s1.charAt(i));
            i--;
        }
        while (s2.charAt(j) != '.') {
            d2.append(s2.charAt(j));
            j--;
        }
        d1 = d1.reverse();
        d2 = d2.reverse();
        int len1 = d1.length();
        int len2 = d2.length();
        while(len1>len2){
            d2.append("0");
            len1--;
        }
        while(len2>len1){
            d1.append("0");
            len2--;
        }
        int l= d1.length()-1;
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(l>=0){
            int temp = (d1.charAt(l)-'0') + (d2.charAt(l)-'0') + carry;
            sb.append(temp%10);
            carry = temp/10;
            l--;
        }
        String sb1 = addString(s1,s2,i-1,j-1,carry);
        System.out.println("Left:" + sb1);
        sb = sb.reverse();
        String ans = sb1 + "." + sb.toString();
        return ans;


       
    }
    public static String addString(String s1,String s2,int i,int j,int carry){
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int p1 = i>=0?(s1.charAt(i)-'0'):0;
            int p2 = j>=0?(s2.charAt(j)-'0'):0;
            int temp = p1+p2 + carry;
            sb.append(temp%10);
            carry = temp/10;
            i--;
            j--;
        }
        if(carry>0){
            sb.append(carry + "");
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String s1 = "11.";
        String s2 = "123.456";
        System.out.println(addStringDecimal(s1,s2));
    }

}
