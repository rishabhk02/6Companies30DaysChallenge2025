package Amazon;
import java.util.*;

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){
                left[i]+=left[i-1];
            }
        }
        for(int i=n-2; i>=0; i--){
            if(arr[i]>arr[i+1]){
                right[i]+=right[i+1];
            }
        }
        int res = 0;
        for(int i=1; i<n-1; i++){
            if(left[i]>1 && right[i]>1){
                res = Math.max(res,left[i]+right[i+1]);
            }
        }
        return res<=1?0:res;
    }
}
