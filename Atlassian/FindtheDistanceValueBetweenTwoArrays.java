import java.util.*;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res=0;
        for(int i=0; i<arr1.length; i++){
            boolean flag=true;
            for(int j=0; j<arr2.length; j++){
                if(d>=Math.abs(arr1[i]-arr2[j])){
                    flag=false; break;
                }
            }
            if(flag) res++;
        }
        return res;
    }
}