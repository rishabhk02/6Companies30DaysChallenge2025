import java.util.*;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n=nums.length;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            int cnt=0; StringBuilder hash = new StringBuilder();
            for(int j=i; j<n; j++){
                if(nums[j]%p==0) cnt++;
                if(cnt>k) break;
                hash.append(',');
                hash.append(nums[j]);
                set.add(hash.toString());
            }
        }
        return set.size();
    }
}