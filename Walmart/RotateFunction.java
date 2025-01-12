package Walmart;

class Solution {
    public int maxRotateFunction(int[] nums) {
        long tot=0l; long cur=0l; int n=nums.length;
        for(int i=0; i<n;i++){
            tot+=nums[i]; cur+=(i*nums[i]);
        }
        long res=cur;
        for(int i=1; i<n; i++){
            cur+=tot; cur-=(nums[n-i]*n);
            res=Math.max(res,cur);
        }
        return (int)res;
    }
}
