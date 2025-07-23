package bitwise;

public class FindKthBitinNthBinaryString {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for(int i=1;i<n;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<sb.length();j++){
                if(sb.charAt(j)=='0'){
                    temp.append('1');
                }
                else{
                    temp.append('0');
                }
            }
            StringBuilder newSb = new StringBuilder();
            newSb.append(sb);
            newSb.append("1");
            newSb.append(temp.reverse());
            sb = new StringBuilder(newSb);

        }
        return sb.charAt(k);
    }
    public static void main(String[] args) {
        int k = 1;
        int n = 3;
        System.out.println(new FindKthBitinNthBinaryString().findKthBit(n, k));
    }

}
