package backtracking;

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] arr) {
        StringBuilder s = new StringBuilder();
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                for(int k=0;k<arr.length;k++){
                    for(int l=0;l<arr.length;l++){
                        if(i==j || i==k || i==l || j==k || j==l || k==l){
                            continue;
                        }
                        count++;
                        if(valid(arr[i],arr[j],arr[k],arr[l])){
                            StringBuilder sb = new StringBuilder();
                            sb.append(arr[i]);
                            sb.append(arr[j]);
                            sb.append(arr[k]);
                            sb.append(arr[l]);
                            System.out.println(sb);
                            if(sb.compareTo(s)>0){
                                s = sb;
                            }
                        }

                    }
                }
            }
            
        }
        System.out.println(count);
        return s.toString();
        
    }
    public boolean valid(int i,int j, int k, int l){
        int h = i*10+j;
        int m = k*10+l;
        if(h<24 && m<60){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr  = {1,2,3,4};
        System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(arr));

    }

}
