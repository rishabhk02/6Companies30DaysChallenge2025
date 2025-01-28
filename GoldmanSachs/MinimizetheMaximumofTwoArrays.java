package GoldmanSachs;

import java.util.*;;

class Solution {
    int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int minimizeSet(int div1, int div2, int m, int n) {
        long low=0l; long high=(long)1e10; long res=high;
        long lcm=(div1*1l*div2)/gcd(div1,div2);
        while(low<=high){
            long mid=(low+high)/2;
            long cnt1=mid-mid/div1;
            long cnt2=mid-mid/div2;
            long cntA=mid-mid/lcm;
            if(cnt1<m || cnt2<n || cntA<m+n){
                low=mid+1;
            }else{
                res=mid;
                high=mid-1;
            }
        }
        return (int)res;
    }


}