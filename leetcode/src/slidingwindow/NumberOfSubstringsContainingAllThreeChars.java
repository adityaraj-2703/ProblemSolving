package slidingwindow;

public class NumberOfSubstringsContainingAllThreeChars {
    public int numberOfSubstrings(String s) {
        int[] f = new int[3];
        int i=0;
        int j=0;
        int count = 0;
        while(j<s.length() && i<s.length()){
            f[s.charAt(j)-'a']++;
            while(f[0]>0 && f[1]>0 && f[2]>0){
                count += s.length()-j;
                f[s.charAt(i)-'a']--;
                i++;
                
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        NumberOfSubstringsContainingAllThreeChars obj = new NumberOfSubstringsContainingAllThreeChars();
        System.out.println(obj.numberOfSubstrings("abcabc"));
    }

}
