import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = find(hBars), y = find(vBars);
        System.out.println(x+" "+y);
        int res = Math.min(x, y) + 1;
        
        return res * res;
    }
    
    private int find(int[] arr) {
        Arrays.sort(arr);
        int res = 1, i = 0, n = arr.length;
        
        while (i < n) {
            int count = 1;
            
            while (i+1 < n && arr[i]+1 == arr[i+1]) {
                i++;
                count++;
            }
            i++;
            res = Math.max(res, count);
        }
        
        return res;
    }
}