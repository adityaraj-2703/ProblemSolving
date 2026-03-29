package bitwise;

public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int i=1;
        int powi = 0;
        while(i<left){
            i = i<<1;
            powi++;
            if(i>left || i<0){
                powi--;
                break;
            }
        }

        int j=1;
        int powj = 0;
        while(j<right){
            j = j<<1;
            powj++;
            if(j>right || j<0){
                powj--;
                break;
            }
        }

        System.out.println(powi + "," + powj);
        if(i!=j){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        RangeBitwiseAnd obj = new RangeBitwiseAnd();
        System.out.println(obj.rangeBitwiseAnd(1,2147483647));
    }

}
