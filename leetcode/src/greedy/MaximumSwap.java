package greedy;

public class MaximumSwap {
    public int maximumSwap(int num) {
        String s = num+"";
        char[] c = s.toCharArray();
        for(int i=0;i<s.length();i++){
            char max = '0';
            int temp = -1;
            for(int j=i+1;j<s.length();j++){
                if(max<s.charAt(j)){
                    max = s.charAt(j);
                    temp = j;
                }

            }
            if(max>s.charAt(i)){
                char t = s.charAt(i);
                c[i] = max;
                c[temp] = t;
                break;
            } 
        }
        String str = new String(c);
        return Integer.parseInt(str);
        
    }
    public static void main(String[] args) {
        int t = 2736;
        MaximumSwap m = new MaximumSwap();
        System.out.println(m.maximumSwap(t));
    }

}
