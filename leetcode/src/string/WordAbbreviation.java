package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String,Integer> hm = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<words.size();i++){
            String str = internalize(words.get(i));
            if(hm.containsKey(str)){
                int k = hm.get(str);
                String[] ans1 = findUnique(k,i,words);
                ans.remove(k);

                hm.put(ans1[0],k);
                ans.add(k,ans1[0]);

                hm.put(ans1[1],i);
                ans.add(i,ans1[1]);
            }
            else{
                hm.put(str,i);
                ans.add(i,str);
            }
        }
        return ans;

    }
    public String[] findUnique(int x,int y,List<String> words){
        int i=0;
        int j=0;
        int n = words.get(x).length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(i<words.get(x).length()){
            if(words.get(x).charAt(i)==words.get(y).charAt(j)){
                
                sb1.append(words.get(x).charAt(i));
                sb2.append(words.get(y).charAt(i));
                i++;
                j++;
            }
            else{
                if((n-i-1)<=2){
                    String[] ans = new String[2];
                    ans[0] = words.get(x);
                    ans[1] = words.get(y);
                    return ans;
                }
                sb1.append(words.get(x).charAt(i));
                sb2.append(words.get(y).charAt(j));
                sb1.append((n-i-2) + "");
                sb1.append(words.get(x).charAt(n-1));
                sb2.append((n-j-2) + "");
                sb2.append(words.get(y).charAt(n-1));
                String[] ans = new String[2];
                ans[0] = sb1.toString();
                ans[1] = sb2.toString();
                return ans;
            }

        }
        return new String[0];
    }
    public String internalize(String word){
        if(word.length()<4){
            return word;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append((word.length()-2) + "");
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("abcdefg","abccefg","abcckkg");
        System.out.println(new WordAbbreviation().wordsAbbreviation(words));
    }

}
