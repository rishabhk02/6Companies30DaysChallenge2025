package Amazon;
import java.util.*;

class Solution{
    static String matrixChainOrder(int p[]){
        // code here
        int n = p.length;
        String res[][] = new String[n+1][n+1];
        int dp[][] = new int[n+1][n+1];
        for(int row[]: dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        char c='A';
        for(int i=0; i<n-1; i++){
            res[i][i+1]=c+""; dp[i][i+1]=0; c++;
        }
        for(int gap=2; gap<n; gap++){
            for(int i=0, j=gap; j<n; i++,j++){
                for(int k=i+1; k<j; k++){
                    int val=p[i]*p[k]*p[j]+dp[i][k]+dp[k][j];
                    if(val<dp[i][j]){
                        dp[i][j]=val;
                        String cur = "("+res[i][k]+res[k][j]+")";
                        res[i][j]=cur;
                    }
                }
            }
        }
        return res[0][n-1];
    }
}
