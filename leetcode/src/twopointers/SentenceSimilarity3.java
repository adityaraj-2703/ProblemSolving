package twopointers;

public class SentenceSimilarity3 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if(!s1[0].equals(s2[0]) && !s1[s1.length-1].equals(s2[s2.length-1])){
            return false;
        }
        int i = 0;
        int j = 0;
        boolean flag  = false;
        while(i<s1.length && j<s2.length){
            if(!s1[i].equals(s2[j]) && !flag){
                flag = true;
            }
            else if(!s1[i].equals(s2[j]) && flag){
                return false;
            }
            i++;
            j++;
        }
        return true;


    }
    public static void main(String[] args) {
        String sentence1 = "c h p Ny";
        String sentence2 = "c BDQ r h p Ny";
        System.out.println(new SentenceSimilarity3().areSentencesSimilar(sentence1, sentence2));

    }

}
