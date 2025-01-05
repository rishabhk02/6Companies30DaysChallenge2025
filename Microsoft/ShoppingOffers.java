import java.util.*;

class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price,special,needs);
    }

    String getKey(List<Integer> needs){
        StringBuilder res = new StringBuilder();
        for(Integer v: needs){
            res.append(v); res.append(',');
        }
        return res.toString();
    }

    int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        String key = getKey(needs);
        if(map.containsKey(key)) return map.get(key);
        int res = 0;
        for(int i=0; i<needs.size(); i++){
            res+=(needs.get(i)*price.get(i));
        }
        for(int i=0; i<special.size(); i++){
            if(isPossible(needs,special.get(i))){
                List<Integer> curNeed = new ArrayList<>();
                for(int j=0; j<needs.size(); j++){
                    curNeed.add(needs.get(j)-special.get(i).get(j));
                }
                res=Math.min(res,special.get(i).get(needs.size())+helper(price,special,curNeed));
            }
        }
        map.put(key,res);
        return res;
    }

    boolean isPossible(List<Integer> curNeed, List<Integer> special){
        for(int i=0; i<curNeed.size(); i++){
            if(curNeed.get(i)<special.get(i)) return false;
        }
        return true;
    }
}