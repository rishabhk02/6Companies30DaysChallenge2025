package Walmart;

import java.util.*;
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
        int brr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            brr[i]=new int[]{i,nums[i]};
        }
        Arrays.sort(brr,new Comparator<>(){
            public int compare(int a[],  int b[]){
                return Integer.compare(b[1],a[1]);
            }
        });
        int res[][] = new int[k][2];
        for(int i=0; i<k; i++){
            res[i][0]=brr[i][0];
            res[i][1]=brr[i][1];
        }
        Arrays.sort(res,new Comparator<>(){
            public int compare(int a[],  int b[]){
                return Integer.compare(a[0],b[0]);
            }
        });
        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i]=res[i][1];
        }
        return ans;
    }
}