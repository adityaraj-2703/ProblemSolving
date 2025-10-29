package twopointers;

public class ValidAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0;
        int j=0;
        while(i<=word.length() && j<abbr.length()){
            if(i==word.length() || j==abbr.length()){
                break;
            }
            if(abbr.charAt(j)>='a' && abbr.charAt(j)<='z'){
                if(word.charAt(i)==abbr.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    return false;
                }
            }
            else{
                int nums = 0;
                while(j<abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9'){
                    nums = nums*10 + (abbr.charAt(j)-'0');
                    j++;
                }
                i+=nums;

            }
        }
        return i==word.length() && j==abbr.length();
    }
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(new ValidAbbreviation().validWordAbbreviation(word, abbr));
    }

}
