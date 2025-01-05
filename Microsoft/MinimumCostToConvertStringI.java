import java.util.*;
class Solution {
    public long minimumCost(String src, String tar, char[] org, char[] chng, int[] cost) {
        int n=src.length(); int m=org.length; long max=(long)1e13;
        long dp[][] = new long[26][26];
        for(long row[]: dp){
            Arrays.fill(row,max);
        }
        for(int i=0; i<26; i++) dp[i][i]=0;
        for(int i=0; i<m; i++){
            int a=org[i]-'a'; int b=chng[i]-'a';
            dp[a][b]=Math.min(dp[a][b],cost[i]);
        }
        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    if(dp[i][k]!=max && dp[k][j]!=max){
                        dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                    }
                }
            }
        }
        long res=0l;
        for(int i=0; i<n; i++){
            int a=src.charAt(i)-'a'; int b=tar.charAt(i)-'a';
            if(dp[a][b]==max) return -1;
            res+=dp[a][b];
        }
        return res;
    }
}