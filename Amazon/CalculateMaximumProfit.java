package Amazon;
import java.util.*;
class Solution {
    int dp[][][];
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        dp=new int[n][k+1][2];
        for(int row[][]: dp){
            for(int col[]: row){
                Arrays.fill(col,-1);
            }
        }
        return helper(0,0,k,n,prices);
    }

    int helper(int curIdx, int canBuy, int tranRemain, int n, int prices[]){
        if(tranRemain==0 || curIdx==n) return 0;
        if(dp[curIdx][tranRemain][canBuy]!=-1) return dp[curIdx][tranRemain][canBuy];
        if(canBuy==0){
            int buy=-prices[curIdx]+helper(curIdx+1,1,tranRemain,n,prices);
            int notBuy=helper(curIdx+1,0,tranRemain,n,prices);
            return dp[curIdx][tranRemain][canBuy]=Math.max(buy,notBuy);
        }else{
            int sell=prices[curIdx]+helper(curIdx+1,0,tranRemain-1,n,prices);
            int notSell=helper(curIdx+1,1,tranRemain,n,prices);
            return dp[curIdx][tranRemain][canBuy]=Math.max(sell,notSell);
        }
    }
}