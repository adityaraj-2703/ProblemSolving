package dynamicprogramming;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int totalcost  = calculate(days,costs,0,0);
        return totalcost;
    }
    public int calculate(int[] days,int[] costs,int ind,int till){
        if(ind==days.length){
            return 0;
        }
        if(till>= days[ind]){
            return calculate(days,costs,ind+1,till);
        }
        int cost1 = costs[0] + calculate(days,costs,ind+1,0);
        int cost2 = costs[1] + calculate(days,costs,ind+1,days[ind]+6);
        int cost3 = costs[2] + calculate(days,costs,ind+1,days[ind]+29);
        return Math.min(cost1,Math.min(cost2,cost3));
    }
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(new MinimumCostForTickets().mincostTickets(days,costs));
    }

}
