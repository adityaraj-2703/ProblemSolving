package array;

public class ATM {
    int[] arr;
    public ATM() {
        arr = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<banknotesCount.length;i++){
            arr[i] += banknotesCount[i];
        }
    }
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        int[] temp = new int[5];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
            if(amount>=500){
                int sub = amount/500;
                int total = Math.min(sub,temp[4]);
                amount -= (total*500);
                ans[4]+=total;
                temp[4]-=total;
            }
            if(amount>=200){
                int sub = amount/200;
                int total = Math.min(sub,temp[3]);
                amount -= total*200;
                ans[3]+=total;
                temp[3]-=total;
            }
            if(amount>=100){
                int sub = amount/100;
                int total = Math.min(sub,temp[2]);
                amount -= total*100;
                ans[2]+=total;
                temp[2]-=total;
            }
            if(amount>=50){
                int sub = amount/50;
                int total = Math.min(sub,temp[1]);
                amount -= total*50;
                ans[1]+=total;
                temp[1]-=total;
            }
            if(amount>=20){
                int sub = amount/20;
                int total = Math.min(sub,temp[0]);
                amount -= total*20;
                ans[0]+=total;
                temp[0]-=total;
            }
        
        if (amount==0){
            for(int i=0;i<arr.length;i++){
                arr[i] = temp[i];
            }

            return ans;
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        int[] res1 = atm.withdraw(600);
        for(int i:res1){
            System.out.print(i+" ");
        }
        System.out.println();
        atm.deposit(new int[]{0,1,0,1,1});
        int[] res2 = atm.withdraw(600);
        for(int i:res2){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] res3 = atm.withdraw(550);
        for(int i:res3){
            System.out.print(i+" ");
        }
        
    }
}