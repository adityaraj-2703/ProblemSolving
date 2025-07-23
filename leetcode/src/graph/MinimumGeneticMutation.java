package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> hs = new HashSet<>();
        for(int i=0;i<bank.length;i++){
            hs.add(bank[i]);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startGene,0));
        while(!q.isEmpty()){
            if(q.peek().val.equals(endGene)){
                return q.peek().steps;
            }
            Pair p = q.poll();
            char[] c = p.val.toCharArray();
            for(int i=0;i<c.length;i++){
                char temp = c[i];

                c[i] = 'A';
                String str = new String(c);
                if(hs.contains(str) && c[i]!=temp){
                    q.add(new Pair(str,p.steps));
                    //hs.remove(str);
                }

                c[i] = 'C';
                str = new String(c);
                if(hs.contains(str) && c[i]!=temp){
                    q.add(new Pair(str,p.steps));
                    //hs.remove(str);
                }

                c[i] = 'G';
                str = new String(c);
                if(hs.contains(str) && c[i]!=temp){
                    q.add(new Pair(str,p.steps));
                    //hs.remove(str);
                }

                c[i] = 'T';
                str = new String(c);
                if(hs.contains(str) && c[i]!=temp){
                    q.add(new Pair(str,p.steps));
                    //hs.remove(str);
                }
                
                c[i] = temp;
            }
        }
        return -1;
    }
    class Pair{
        String val;
        int steps;
        Pair(String val,int steps){
            this.val = val;
            this.steps = steps;
        }
    }
    public static void main(String[] args) {
        MinimumGeneticMutation m = new MinimumGeneticMutation();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(m.minMutation(start, end, bank));
    }

}
