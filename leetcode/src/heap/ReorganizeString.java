package heap;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] f = new int[26];
        int letter = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            int t = s.charAt(i)-'a';
            f[t]++;
            if(f[t]>max){
                max = f[t];
                letter = t;
            }
        }
        if(max>s.length()+1){
            return "";
        }
        int ind = 0;
        char[] ch = new char[s.length()];
        while(f[letter]!=0){
            ch[ind] = (char)(letter+97);
            ind+=2;
            f[letter]--;
        }

        for(int i=0;i<26;i++){
            while(f[i]>0){
                if(ind>=s.length()){
                    ind =1;
                }
                ch[ind] = (char)(i+97);
                ind+=2;
                f[i]--;
            }
        }
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        String s = "aaab";
        String res = new ReorganizeString().reorganizeString(s);
        System.out.println(res);
    }

}
