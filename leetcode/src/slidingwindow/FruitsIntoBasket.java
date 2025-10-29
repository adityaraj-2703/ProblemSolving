package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int j = 0;
        int i=0;
        int max = 0;
        

        while(j<fruits.length){
            if(count==2){
                if(hm.containsKey(fruits[j])){
                    
                }
                else{
                    max = Math.max(j-i+1,max);
                    hm.put(fruits[j],j);
                    while(fruits[i]!=fruits[j] && fruits[i]!=fruits[j-1]){
                        i++;
                    }
                    
                }

            }
            else{
                hm.put(fruits[j],j);
                count++;
            }
            j++;
        }
        return Math.max(j-i,max);
    }
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new FruitsIntoBasket().totalFruit(fruits));

    }

}
