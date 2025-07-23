package string;

public class FindKthCharacterinaStringGame2 {
    public char kthCharacter(long k, int[] operations) {
        StringBuilder sb = new StringBuilder("a");
        long tot=1;
        for(int i=0;i<operations.length;i++){
            if(operations[i]==0){
                long temp=sb.length();
                String tempStr = sb.toString();
                sb.append(sb);
                if(tot+temp>=k){
                    return tempStr.charAt((int)(k-tot));
                }
                tot+=temp;

            }
            else{
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<sb.length();j++){
                    if(sb.charAt(i)=='z'){
                        temp.append('a');
                    }
                    else{
                        temp.append((char)(sb.charAt(i)+1));
                    }
                }
                long tempI=temp.length();
                sb.append(temp);
                if(tot+tempI>=k){
                    return temp.charAt((int)(k-tot-1));
                }
                tot+=tempI;
            }
        }
        return sb.charAt((int)(k-tot));
    }
    public static void main(String[] args) {
        long k = 4;
        int[] op = {0,1};
        FindKthCharacterinaStringGame2 f = new FindKthCharacterinaStringGame2();
        System.out.println(f.kthCharacter(k, op));
    }

}
