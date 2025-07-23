package string;

public class FindKthCharacterInAStringGame {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        
        while(sb.length()<k){
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)-'a'<26){
                    temp.append((char)(sb.charAt(i)+1));
                }
                else{
                    temp.append("a");
                }
            }
            sb.append(temp);
        }
        return sb.charAt(k-1);
    }
    public static void main(String[] args) {
        int k = 5;
        FindKthCharacterInAStringGame h = new FindKthCharacterInAStringGame();
        System.out.println(h.kthCharacter(k));
    }

}
