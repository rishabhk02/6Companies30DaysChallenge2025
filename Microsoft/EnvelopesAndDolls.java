import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] env) {
        int n=env.length;
        Arrays.sort(env,new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
                return Integer.compare(a[0],b[0]);
            }
        });
        int heights[] = new int[n]; int idx=1;
        heights[0]=env[0][1];
        for(int i=1; i<n; i++){
            if(heights[idx-1]<env[i][1]){
                heights[idx++]=env[i][1];
            }else{
                int nxt=search(heights,idx,env[i][1]);
                heights[nxt]=env[i][1];
            }
        }
        return idx;
    }

    int search(int arr[], int n, int v){
        int l=0; int r=n-1; int res=n-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]>=v){
                res=m;
                r=m-1;
            }else l=m+1;
        }
        return res;
    }
}