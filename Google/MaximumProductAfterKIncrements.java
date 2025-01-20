package Google;
import java.util.*;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val: nums) pq.add(val);
        while(k>0){
            int val = pq.poll();
            pq.add((val+1));
            k--;
        } 
        int mod=1000000007;
        long res=1;
        while(!pq.isEmpty()){
            res = (res*pq.poll())%mod;
        } 
        return (int)res;      
    }
}