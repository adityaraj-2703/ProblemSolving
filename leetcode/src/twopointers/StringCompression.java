package twopointers;

public class StringCompression {
    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        while(j<chars.length){
            int count = 0;
            char c = chars[j];
            while(j<chars.length && chars[j]==c){
                count++;
                j++;
            }
            i++;
            if(count==1){
                continue;
            }
            while(count>0){
                chars[i++] = (char)(count%10 + '0');
                count/=10;
            }

        }
        return i;
    }
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int res = new StringCompression().compress(chars);
        System.out.println(res);
    }

}
