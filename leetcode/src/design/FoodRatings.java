package design;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {

    
    Map<String,PriorityQueue<Map.Entry<String,Integer>>> foodRating;
    Map<String,String> cuisinesMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodRating = new HashMap<>();
        cuisinesMap = new HashMap<>();
        for(int i=0;i<foods.length;i++){
            //List<String> li = foodItem.getOrDefault(cuisines[i],new ArrayList<>());
            PriorityQueue<Map.Entry<String,Integer>> pq = foodRating.getOrDefault(cuisines[i], new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>() {
                public int compare(Map.Entry<String,Integer> m1, Map.Entry<String,Integer> m2){
                    if(m1.getValue() == m2.getValue()){
                        return m1.getKey().compareTo(m2.getKey());
                    }
                    return m2.getValue() - m1.getValue();
                }
            }
            ));
            foodRating.put(cuisines[i],pq);
            cuisinesMap.put(foods[i],cuisines[i]);
            
        }
        for(int i=0;i<foods.length;i++){
            //rating.put(foods[i],ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisines = cuisinesMap.getOrDefault(food,null);
        if(cuisines!=null){
            PriorityQueue<Map.Entry<String,Integer>> pq = foodRating.getOrDefault(cuisines,null);
            if(pq!=null){
                
            }
        }
    }
    
    public String highestRated(String cuisine) {
        int maxRating = 0;
        String maxRatingFood = "";
        //List<String> li = foodItem.getOrDefault(cuisine,new ArrayList<>());
        // for(String food : li){
        //     if(//rating.get(food)>maxRating){
        //         maxRating = rating.get(food);
        //         maxRatingFood = food;
        //     }
        //     else if(rating.get(food) == maxRating){
        //         if(food.compareTo(maxRatingFood)<0){
        //             maxRatingFood = food;
        //         }
        //     }
        // }
        return maxRatingFood;
    }
}