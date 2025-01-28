package GoldmanSachs;
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int mask=1<<9;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<mask; i++){
            int bit=Integer.bitCount(i);
            if(bit!=k) continue;
            int sum=0;
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<9; j++){
                if((i&1<<j)!=0){
                    sum+=(j+1);
                    l.add((j+1));
                }
            }
            if(sum==n) res.add(l);
        }
        return res;
    }
}