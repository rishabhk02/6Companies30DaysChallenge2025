package Amazon;
import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        long max=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            sum+=nums[i];
            if(i>=k-1){
                if(hm.size()==k)    max=Math.max(max,sum);
                sum-=nums[i-k+1];
                hm.put(nums[i-k+1],hm.get(nums[i-k+1])-1);
                if(hm.get(nums[i-k+1])==0)  hm.remove(nums[i-k+1]);
            }
        }
        return max;
    }
}
