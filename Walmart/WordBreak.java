package Walmart;
import java.util.*;
class Solution {
    int vis[];
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        vis = new int[n];
        return helper(s,0,n,wordDict);
    }

    boolean helper(String s, int idx, int n, List<String> dict){
        if(idx==n) return true;
        if(vis[idx]==1) return false;
        vis[idx] = 1;
        StringBuilder cur = new StringBuilder();
        for(int i=idx; i<n; ++i){
            cur.append(s.charAt(i));
            if(dict.indexOf(cur.toString())!=-1 && helper(s,i+1,n,dict)) return true;
        }
        return false;
    }
}