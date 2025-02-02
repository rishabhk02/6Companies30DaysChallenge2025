class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n+1];
        dp[1]=1l; int mod=(int)1e9+7;
        long share=0l;
        for(int i=2; i<=n; i++){
            dp[i]=share;
            if(i-delay>=0){
                dp[i]+=dp[i-delay];
                dp[i]%=mod;
            }
            if(i-forget>=0){
                dp[i]=dp[i]+mod-dp[i-forget];
                dp[i]%=mod;
            }
            share=dp[i];        
        }
        long res=0l;
        for(int i=n-forget+1; i<=n; i++){
            res=(res+dp[i])%mod;
        }
        return (int)res;
    }
}