package prefixsum;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = 0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int i=0;
        int j=k;
        max = Math.max(max,sum);
        while(i<cardPoints.length){
            if(j==cardPoints.length){
                j=0;
            }
            sum-=cardPoints[i];
            sum+=cardPoints[j];
            max = Math.max(max,sum);
            i++;
            j++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(cardPoints,k));
    }

}
