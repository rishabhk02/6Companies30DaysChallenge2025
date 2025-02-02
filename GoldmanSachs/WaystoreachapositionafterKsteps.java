class Solution {
    int mod=(int)1e9+7;
    public int numberOfWays(int s, int e, int k) {
        int dist=Math.abs(s-e);
        if(dist>k || Math.abs(dist-k)%2!=0) return 0;
        // x is positive moves // y is negative moves;
        // 1*x-1*y=dist && x+y=k;

        int x=(dist+k)/2;
        // total moves=k, we have to select x moves from k C(k,x);
        long numK=1l;
        for(int i=1; i<=k; i++){
            numK=(numK*i)%mod;
        }

        long denX=1l; long denY=1l;
        for(int i=1; i<=x; i++) denX=(denX*i)%mod;
        for(int i=1; i<=(k-x); i++) denY=(denY*i)%mod;
        long den=(denX*denY)%mod;

        long modVal=modInv(den,mod);
        long res=(numK*modVal)%mod;
        return (int)res;
    }

    int modInv(long a, int b){
        long val=a; long res=1l;
        b-=2;
        while(b!=0){
            if((b&1)!=0){
                res*=val; res%=mod;
            }
            b>>=1;
            val*=val; val%=mod;
        }
        return (int)res;
    }
}


// IMP Discuss Link ==> https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/solutions/2527527/is-the-mathematics-way-available/