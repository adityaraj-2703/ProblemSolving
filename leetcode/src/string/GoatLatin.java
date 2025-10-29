package string;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<words.length;i++){
            StringBuilder sb = new StringBuilder(words[i]);
            if(isVowel(sb.charAt(0))){
                sb.append("ma");
            }
            else{
                sb.deleteCharAt(0);
            }
            for(int j=0;j<=i;j++){
                sb.append("a");
            }
            ans.append(sb + " ");

        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || 
        c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
    public static void main(String[] args) {
        String s = "I speak Goat Latin";
        System.out.println(new GoatLatin().toGoatLatin(s));
    }

}
