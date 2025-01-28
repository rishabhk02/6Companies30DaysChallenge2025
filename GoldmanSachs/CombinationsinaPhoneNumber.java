package GoldmanSachs;
import java.util.*;

class Solution {
    String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        helper(0,digits.length(),new StringBuilder(),digits);
        return res;
    }

    void helper(int idx, int n, StringBuilder cur, String digit){
        if(idx==n){
            if(cur.length()!=0) res.add(new String(cur));
            return;
        }
        int d=digit.charAt(idx)-'0';
        for(int i=0; i<arr[d].length(); i++){
            cur.append(arr[d].charAt(i));
            helper(idx+1,n,cur,digit);
            cur.deleteCharAt(cur.length()-1);
        }
        return;
    }
}