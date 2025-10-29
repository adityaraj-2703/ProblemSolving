package string;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int ind = 0;
        int counter = 0;
        for(int i=0;i<abbr.length();i++){
            if(Character.isDigit(abbr.charAt(i))){
                int temp = abbr.charAt(i) - '0';
                if(counter==0 && temp==0){
                    return false;
                }
                counter = counter*10 + temp;
            }
            else{
                ind = ind + counter;
                counter = 0;
                if(ind>=word.length() || word.charAt(ind)!=abbr.charAt(i)){
                    return false;
                }
                ind++;
            }
        }
        
        if(ind<word.length() && counter==0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i5a11o1";
        System.out.println(new ValidWordAbbreviation().validWordAbbreviation(word, abbr));
    }

}
