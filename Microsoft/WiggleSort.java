import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        int res[] = nums.clone();
        Arrays.sort(res);
        int n=nums.length; int i=1; int j=n-1;
        while(i<n){
            nums[i]=res[j];
            i+=2; j--;
        }
        i=0;
        while(i<n){
            nums[i]=res[j];
            i+=2; j--;
        }

        return;
    }
}