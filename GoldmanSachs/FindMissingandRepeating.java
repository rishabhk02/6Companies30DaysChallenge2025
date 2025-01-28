package GoldmanSachs;

import java.util.*;



// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int rep = -1;
        for(int i=0; i<n; i++){
            int val = Math.abs(arr[i]);
            if(arr[val-1]<0) rep = arr[i];
            else arr[val-1] = -1*arr[val-1];
        }
        int mis = -1;
        for(int i=0; i<n; i++){
            if(arr[i]>0){
                mis = i+1;
                break;
            }
        }
        return new int[]{Math.abs(rep),mis};
    }
}