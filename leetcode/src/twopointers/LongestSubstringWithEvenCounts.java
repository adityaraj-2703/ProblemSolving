package twopointers;

public class LongestSubstringWithEvenCounts {
    public int findTheLongestSubstring(String s) {
        int[] f = new int[26];
        int i=0;
        int j=0;
        int max = 0;
        while(j<s.length()){
            f[s.charAt(j)-'a']++;
            if(check(f)){
                max = Math.max(max,j-i+1);
            }
            else{
                while(!check(f)&& i<=j){
                    f[s.charAt(i)-'a']--;
                    i++;
                }
            }
            j++;
        }
        return max;
    }
    public boolean check(int[] f){
        if(f[0]%2!=0 || f[4]%2!=0 || f[8]%2!=0 || f['o'-'a']%2!=0 || f['u'-'a']%2!=0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        int res = new LongestSubstringWithEvenCounts().findTheLongestSubstring(s);
        System.out.println(res);
        
    }

}
