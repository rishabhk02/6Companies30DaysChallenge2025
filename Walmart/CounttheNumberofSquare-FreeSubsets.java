package Walmart;
import java.util.*;

class Solution {
    int arr[] = {2,3,5,7,11,13,17,19,23,29};

    int xToMask(long x){
        int mask = 0;
        for(int j=0; j<10; j++){
            if(x%arr[j]==0){
                mask |= (1<<j);
                x/=arr[j];
            }
        }
        return mask;
    }

    long maskToX(int mask){
        if(mask==0) return 0l;
        long x=1l;
        for(int i=0; i<10; i++){
            if((mask&1<<i)!=0){
                x*=arr[i];
            }
        }
        return x;
    }

    int dp[][]; int mod=(int)1e9+7;
    public int squareFreeSubsets(int[] nums) {
        int n=nums.length; dp=new int[n][1025];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int oneCnt=0;
        for(int i=0; i<n; i++){
            if(nums[i]==1) oneCnt++;
            else list.add(nums[i]);
        }
        long subsetOne=1l;
        for(int i=1; i<=oneCnt; i++){
            subsetOne*=2; subsetOne%=mod;
        }
        subsetOne-=1;

        long res=0l;
        for(int i=1; i<1024; i++){
            res+=helper(0,list,i); res%=mod;
        }
        long ans=(res+subsetOne)%mod+(res*subsetOne)%mod;
        ans%=mod;
        return (int)ans;
    }

    int helper(int idx, ArrayList<Integer> list, int mask){
        int n=list.size();
        if(mask==0) return 1;
        if(idx==n) return 0;
        if(dp[idx][mask]!=-1) return dp[idx][mask];
        long res=helper(idx+1,list,mask);
        if(maskToX(mask)%list.get(idx)==0){
            res+=helper(idx+1,list,xToMask(maskToX(mask)/list.get(idx)));
            res%=mod;
        }
        return dp[idx][mask]=(int)(res%mod);
    }
}
