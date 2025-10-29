package string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(!isUpper(s.charAt(i)) && !isLower(s.charAt(i))){
                i++;
                continue;
            }
            if(!isUpper(s.charAt(j)) && !isLower(s.charAt(j))){
                j--;
                continue;
            }
            if(isUpper(s.charAt(i))){
                if(isUpper(s.charAt(j))){
                    if(s.charAt(i)==s.charAt(j)){
                        i++;
                        j--;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if((char)(s.charAt(i)+32)==s.charAt(j)){
                        i++;
                        j--;
                    }
                    else{
                        return false;
                    }
                }
            }
            else{
                if(isLower(s.charAt(j))){
                    if(s.charAt(i)==s.charAt(j)){
                        i++;
                        j--;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if((char)(s.charAt(j)+32)==s.charAt(i)){
                        i++;
                        j--;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isUpper(char c){
        return c>=65 && c<=90;
    }
    public boolean isLower(char c){
        return c>=97 && c<=122;
    }
    public static void main(String[] args) {
        String a = "race a car";
        System.out.println(new ValidPalindrome().isPalindrome(a));

    }

}
