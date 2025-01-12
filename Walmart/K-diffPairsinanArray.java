package Walmart;
import java.util.*;;

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0; int n=nums.length;
        HashSet<Integer> has = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            int d=nums[i]-k;
            if(set.contains(d) && !has.contains(nums[i])){
                 has.add(nums[i]);
                 res++;
            }
            set.add(nums[i]);
        }
        return res;
    }
}
