class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n=nums.length;
        int maxIncLeft=0; int minDecRight=n-1;
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]) maxIncLeft=i;
            else break;
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i+1]>nums[i]) minDecRight=i;
            else break;
        }

        int res=0;
        for(int i=0; i<=Math.min(n-1,maxIncLeft+1); i++){
             int prev=(i==0)?-1:nums[i-1];
             int nextR=search(prev,Math.max(minDecRight,i+1),nums);
             res+=(n+1-nextR);
         }

        return res;
    }

    int search(int val, int low, int nums[]){
        int high=nums.length-1; int res=nums.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>val){
                res=mid; high=mid-1;
            }else low=mid+1;
        }
        return res;
    }
}