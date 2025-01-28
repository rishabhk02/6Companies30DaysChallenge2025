import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res=0; int l=0; int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i])>k){
                map.put(nums[l],map.get(nums[l])-1); l++;
            }
            res=Math.max(res,i-l+1);
        }
        return res;
    }
}