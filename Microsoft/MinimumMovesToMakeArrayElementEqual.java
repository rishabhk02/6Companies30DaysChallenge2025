import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long pref[]=new long[n]; 
        long suff[]=new long[n];
        for(int i=1; i<n; i++){
            pref[i]=pref[i-1];
            pref[i]+=i*1l*(nums[i]-nums[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            suff[i]=suff[i+1];
            suff[i]+=(n-1-i)*1l*(nums[i+1]-nums[i]);
        }
        long res=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            long curVal=pref[i]+suff[i];
            res=Math.min(res,curVal);
        }
        
        return (int)res;
    }
}