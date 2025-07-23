package bitwise;

public class SumOfKMirrorNumbers {
    public long kMirror(int k, int n) {
        long sum = 0;
        int i = 0;
        int num = 1;
        while(i<n){
            while(true){
                String s = find(num,k);
                if(checkMirror(num+"") && checkMirror(s)){
                    i++;
                    sum += num;
                    num++;
                    break;
                }
                num++;
            }
            
        }
        return sum;
    }
    public String find(int num,int k){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.append(num%k);
            num/=k;
        }
        return sb.toString();
    }
    public boolean checkMirror(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        SumOfKMirrorNumbers s = new SumOfKMirrorNumbers();
        int k = 3;
        int n = 7;
        System.out.println(s.kMirror(k, n));
    }

}
