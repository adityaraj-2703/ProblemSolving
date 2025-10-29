package dynamicprogramming;

public class SoupServings {
    public double soupServings(int n) {
        return soupServingsUtil(n,n,1);
    }
    public double soupServingsUtil(int a,int b,double val){
        if(a==0 && b==0){
            return val*0.5;
        }
        if(a<=0 && b>0){
            return val*1;
        }
        if(b<=0){
            return 0;
        }
        double x1 = soupServingsUtil(a-100,b,val/4);
        double x2 = soupServingsUtil(a-75,b-25,val/4);
        double x3 = soupServingsUtil(a-50,b-50,val/4);
        double x4 = soupServingsUtil(a-25,b-75,val/4);

        double ans = x1+x2+x3+x4;
        return ans;

    }
    public static void main(String[] args) {
        SoupServings ss = new SoupServings();
        int n = 100;
        System.out.println(ss.soupServings(n));
    }

}
