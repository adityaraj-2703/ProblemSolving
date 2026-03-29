package string;

public class LexiSmall {
    public String lexSmallestAfterDeletion(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        char p = '^';
        int cc = 1;
        int pc = 0;
        int i = 1;
        sb.append(s.charAt(0));
        while(i<s.length()){
            if(s.charAt(i)==c){
                cc++;
            }
            else{
                p = c;
                c = s.charAt(i);
                pc = cc;
                cc = 1;
                if(p>c && pc>1){
                    sb.deleteCharAt(sb.length()-1);
                }
                
            }
            sb.append(s.charAt(i));
            i++;
            
        }
        return sb.toString();
        
    }
    public static void main(String[] args) {
        LexiSmall l = new LexiSmall();
        System.out.println(l.lexSmallestAfterDeletion("ccbab"));
    }

}
