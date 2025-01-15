package Walmart;
import java.util.*;;
class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        int freq[] = new int[256];
        ArrayList<Character> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            freq[c]++; if(freq[c]==1) list.add(c);
        }
        
        Collections.sort(list,new Comparator<Character>(){
            public int compare(Character a, Character b){
                return Integer.compare(freq[b],freq[a]);
            }
        });

        StringBuilder res = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<freq[list.get(i)]; j++){
                res.append(list.get(i));
            }            
        }
        return res.toString();
    }
}