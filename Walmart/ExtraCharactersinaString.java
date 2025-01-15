package Walmart;
import java.util.*;

class Solution {
    HashSet<String> set; int dp[];
    public int minExtraChar(String s, String[] dict) {
        set = new HashSet<>();
        for(String d: dict) set.add(d);
        int n=s.length(); dp=new int[n];
        dp[0]=(set.contains(s.substring(0,1)))?0:1;
        for(int i=1; i<n; i++){
            dp[i] = 1+dp[i-1];
            String cur = "";
            for(int j=i; j>=0; j--){
                cur=s.charAt(j)+cur;
                if(set.contains(cur)){
                    int val=(j==0)?0:dp[j-1];
                    dp[i]=Math.min(dp[i],val);
                }
            }
        }
        return dp[n-1];
    }
}