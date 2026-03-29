package bitwise;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        
        List<String> li = new ArrayList<>();
        if(turnedOn==0){
            li.add("00:00");
            return li;
        }
        int[] temp = new int[2];
        readBinary(li,temp,turnedOn,0);
        return li;
    }
    public void readBinary(List<String> li, int[] temp, int t,int i){
        if(t==0){
            if(temp[0]>11 || temp[1]>59){
                return;
            }
            StringBuilder sb = new StringBuilder();
            if(temp[0]<10){
                sb.append('0');
            }
            sb.append(temp[0]);
            sb.append(":");
            if(temp[1]<10){
                sb.append('0');
            }
            sb.append(temp[1]);
            li.add(sb.toString());

            return;
        }
        for(int j=i;j<10;j++){
            if(j<4){
                temp[0] += Math.pow(2,j);
                readBinary(li,temp,t-1,j+1);
                temp[0] -= Math.pow(2,i);
            }
            else{
                temp[1] += Math.pow(2,j-4);
                readBinary(li,temp,t-1,j+1);
                temp[1] -= Math.pow(2,j-4);
            }
        }
            
        
    }
    public static void main(String[] args) {
        BinaryWatch obj = new BinaryWatch();
        System.out.println(obj.readBinaryWatch(1));
        
    }

}
