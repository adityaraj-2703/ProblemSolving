package string;

public class Atoi {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean sign = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                if(s.charAt(i)=='-' && sb.length()==0){
                    sign = false;
                }
                else if(s.charAt(i)>='1' && s.charAt(i)<='9'){
                    sb.append(s.charAt(i));
                }
                else if(s.charAt(i)=='0' && sb.length()>0){
                    sb.append(s.charAt(i));
                }
                else if(s.charAt(i)=='0' && sb.length()==0){
                    continue;
                }
                else{
                    break;
                }
            }
            

        }
        if(sb.length()==0){
            return 0;
        }
        int temp =  Integer.parseInt(sb.toString());
        return sign?temp:-temp;
    }
    public static void main(String[] args) {
        String s = "   -042";
        Atoi a = new Atoi();
        System.out.println(a.myAtoi(s));
    }

}
