import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        StringBuilder cur = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            cur.append(c);
            if(i>=9){
                map.put(cur.toString(),map.getOrDefault(cur.toString(),0)+1);
                cur.deleteCharAt(0);
            }            
        }
        List<String> res = new ArrayList<>();
        for(String key: map.keySet()){
            if(map.get(key)>=2) res.add(key);
        }
        return res;
    }
}