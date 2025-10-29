package dynamicprogramming;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatchUtil(s,p,s.length()-1,p.length()-1);
    }
    public boolean isMatchUtil(String s, String p,int i,int j){
        if(i<0 && j<0){
            return true;
        }
        if(i<0){
            while(j>=0 && p.charAt(j)=='*'){
                j--;
            }
            return j<0;
        }
        if(j<0 && i>=0){
            return false;
        }
        if(s.charAt(i)==p.charAt(j)){
            return isMatchUtil(s,p,i-1,j-1);
        }
        else if(p.charAt(j)=='.'){
            return isMatchUtil(s,p,i-1,j-1);
        }
        else if(p.charAt(j)=='*'){
            char c = p.charAt(j-1);
            if(s.charAt(i)==c || c=='.'){
                return isMatchUtil(s,p,i-1,j-2) || isMatchUtil(s,p,i-1,j);
            }
            else{
                return isMatchUtil(s,p,i-1,j-2);
            }
        }
        else{
            return false;
        }

    }
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }

}
