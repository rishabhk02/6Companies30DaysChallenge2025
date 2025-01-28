import java.util.*;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int ans = 0, mask = 0;
        Set<Integer> startWordsSet = new HashSet<>();
        
        for(String w: startWords){
            mask = 0;
            for(char c: w.toCharArray()) mask |= (1<< (c-'a'));
            startWordsSet.add(mask);
           
        }
        for(String w: targetWords){
            mask = 0;
            for(char c: w.toCharArray()) mask |= (1<< (c-'a'));
            for(char c: w.toCharArray()){
                if(startWordsSet.contains(mask - (1<< (c-'a')))){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}