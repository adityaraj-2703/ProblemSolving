package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> li = new ArrayList<>();
        int len = 0;
        int i=0;
        int j=0;
        int wordLen = 0;
        while(j<words.length){
            if(len + words[j].length() <= maxWidth){
                len += words[j].length() + 1;
                wordLen += words[j].length();
                j++;
            }
            else{
                li.add(addWords(i,j-1,words,wordLen,maxWidth));
                len=0;
                wordLen = 0;
                i=j;
            }
            if(j==words.length){
                li.add(addLast(i,j-1,words,maxWidth));
            }
            
        }
        return li;

    }
    public String addWords(int i,int j,String[] words,int len,int max){
        int space = j-i;
        int noOfSpace = max - len;
        StringBuilder sb = new StringBuilder();
        for(int k=i;k<=j;k++){
            sb.append(words[k]);
            if(noOfSpace==0){
                break;
            }
            int sp = 0;
            if(space==0){
                sp = noOfSpace;
            }
            else if(noOfSpace%(space)!=0){
                sp = noOfSpace/(space) + 1;
            }
            else{
                sp = noOfSpace/(space) ;
            }
            for(int s=0;s<sp;s++){
                sb.append(" ");
            }
            noOfSpace-=sp;
            space--;
        }
        return sb.toString();
    }
    public String addLast(int i,int j,String[] words,int max){
        StringBuilder sb = new StringBuilder();
        for(int k=i;k<=j;k++){
            sb.append(words[k]);
            if(k!=j){
                sb.append(" ");
            }
            
        }
        for(int s=0;s<max-sb.length();i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        TextJustification obj = new TextJustification();
        System.out.println(obj.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
    }

}
