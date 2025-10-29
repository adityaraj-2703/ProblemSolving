package search;

import java.util.Arrays;
import java.util.Comparator;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages); // ascending
        for (int i = 0; i < ages.length / 2; i++) {
            int temp = ages[i];
            ages[i] = ages[ages.length - 1 - i];
            ages[ages.length - 1 - i] = temp;
        }
        int sum = 0;
        for(int i=0;i<ages.length;i++){
            int st = ages[i];
            int l = i+1;
            int r = ages.length-1;
            int ans = -1;
            while(l<=r){
                int m = l + (r-l)/2;
                if((double)ages[m]<= (double)st*0.5 + 7){
                    r = m-1;
                }
                else if(ages[m]>100 && st<100){
                    l = m+1;
                }
                else{
                    ans = m;
                    l = m+1;
                }
            }
            if(ans!=-1){
                sum += ans-i;
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        int[] ages = {20,30,100,110,120};
        System.out.println(new FriendsOfAppropriateAges().numFriendRequests(ages));
    }

}
