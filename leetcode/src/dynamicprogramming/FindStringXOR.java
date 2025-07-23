package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindStringXOR {
    public List<Integer> find(String s){
        List<Integer> li = new ArrayList<>();
        int[] f = new int[26];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=75;i++){
            int tmp = i;
            for(int j=0;j<26;j++){
                f[j] = tmp++;
            }
            int xor = f[s.charAt(0)-'a'];
            for(int j=1;j<s.length();j++){
                xor^=f[s.charAt(j)-'a'];
            }
            if(min>xor){
                min = xor;
                li = new ArrayList<>();
                for(int k=0;k<f.length;k++){
                    li.add(f[k]);
                }
            }


        }
        return li;
    }
    public List<Integer> mapLettersToNumbers(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        List<Character> oddFreqChars = new ArrayList<>();
        // Use a Set to track characters that appeared in the string
        // This helps in separating characters that appeared with even freq
        // vs. characters that did not appear at all (count 0)
        Set<Character> charsInString = new HashSet<>();
        for (char c : s.toCharArray()) {
            charsInString.add(c);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (charCounts[c - 'a'] % 2 != 0) {
                oddFreqChars.add(c);
            }
        }

        int[] result = new int[26]; // To store the final mapping for a-z
        boolean[] usedNumbers = new boolean[101]; // Numbers 1 to 100 (index 0 unused)

        int currentXORSum = 0;
        int nextAvailableNum = 1;

        // Phase 1: Map odd frequency characters to minimize XOR sum
        // Assign k-1 oddFreqChars greedily with smallest available numbers
        // And for the last one, try to make the total XOR sum 0
        if (!oddFreqChars.isEmpty()) {
            for (int i = 0; i < oddFreqChars.size() - 1; i++) {
                char c = oddFreqChars.get(i);
                while (nextAvailableNum <= 100 && usedNumbers[nextAvailableNum]) {
                    nextAvailableNum++;
                }
                if (nextAvailableNum > 100) {
                    // Should not happen for 26 chars in 100 numbers, but good to check
                    throw new IllegalStateException("Not enough distinct numbers for oddFreqChars.");
                }
                result[c - 'a'] = nextAvailableNum;
                usedNumbers[nextAvailableNum] = true;
                currentXORSum ^= nextAvailableNum;
                nextAvailableNum++; // Increment for the next assignment
            }

            // For the last oddFreqChar
            char lastOddChar = oddFreqChars.get(oddFreqChars.size() - 1);
            if (currentXORSum >= 1 && currentXORSum <= 100 && !usedNumbers[currentXORSum]) {
                result[lastOddChar - 'a'] = currentXORSum;
                usedNumbers[currentXORSum] = true;
            } else {
                // If currentXORSum is not valid or already used,
                // assign the smallest available number
                while (nextAvailableNum <= 100 && usedNumbers[nextAvailableNum]) {
                    nextAvailableNum++;
                }
                if (nextAvailableNum > 100) {
                    throw new IllegalStateException("Not enough distinct numbers for last oddFreqChar.");
                }
                result[lastOddChar - 'a'] = nextAvailableNum;
                usedNumbers[nextAvailableNum] = true;
                // No need to update currentXORSum here, as we are assigning the final number,
                // and the resulting XOR sum might not be 0.
                nextAvailableNum++; // Increment for the next assignment
            }
        }
        
        // Phase 2: Map remaining characters (those with even frequency or not in string)
        // Assign them smallest available numbers in alphabetical order
        for (char c = 'a'; c <= 'z'; c++) {
            if (result[c - 'a'] == 0) { // If this character hasn't been mapped yet
                while (nextAvailableNum <= 100 && usedNumbers[nextAvailableNum]) {
                    nextAvailableNum++;
                }
                if (nextAvailableNum > 100) {
                    throw new IllegalStateException("Not enough distinct numbers for remaining characters.");
                }
                result[c - 'a'] = nextAvailableNum;
                usedNumbers[nextAvailableNum] = true;
                nextAvailableNum++; // Increment for the next assignment
            }
        }

        List<Integer> finalMapping = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            finalMapping.add(result[i]);
        }

        return finalMapping;
    }
    public static void main(String[] args) {
        FindStringXOR f  = new FindStringXOR();
        String s  = "xxxxyy";
        List<Integer> li = f.find(s);
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i));
        }
    }
    

}
