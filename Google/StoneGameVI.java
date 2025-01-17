package Google;
import java.util.*;

class Solution {
    public int stoneGameVI(int[] alice, int[] bob) {
        int n=alice.length;
        int arr[][] = new int[n][2]; 
        for(int i=0; i<n; i++){
            arr[i]=new int[]{(alice[i]+bob[i]),i};
        }
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return Integer.compare(b[0],a[0]);
            }
        });
        int a=0; int b=0;
        for(int i=0; i<n; i++){
            if(i%2==0) a+=alice[arr[i][1]];
            else b+=bob[arr[i][1]];
        }
        if(a>b) return 1;
        if(b>a) return -1;
        return 0;        
    }
}