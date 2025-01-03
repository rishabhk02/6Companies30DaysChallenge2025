import java.util.*;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length; int res = 0;
        int pref[] = new int[n]; pref[0] = nums[0]%2;
        for(int i=1; i<n; i++){
            pref[i]=nums[i]%2;
            pref[i]+=pref[i-1];
        }
        HashMap<Integer,Integer> map = new HashMap<>(); map.put(0,1);
        for(int i=0; i<n; i++){
            int req = pref[i]-k;
            res += map.getOrDefault(req,0);
            map.put(pref[i],map.getOrDefault(pref[i],0)+1);
        }
        return res;
    }
}