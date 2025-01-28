import java.util.*;;

class Solution {
    long mod=(long)Math.pow(10,9)+7;
    public int minNonZeroProduct(int p) {
        long num=(long)Math.pow(2,p)-1;
        long ans=pow(num-1,(num-1)/2);
        ans=((ans%mod)*(num%mod))%mod;
        return (int)ans;
    }
    public long pow (long x,long y)
    {
        if(y==0)
            return 1;
        long mod=(long)Math.pow(10,9)+7;
        long temp=pow(x,y/2);
        temp%=mod;
        temp=(temp*temp)%mod;
        if(y%2==1)
            temp=temp*(x%mod);
        temp%=mod;
        return temp;
    }
}