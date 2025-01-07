package Amazon;
import java.util.*;

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]-a[1]);
       ArrayList<Integer> res = new ArrayList<>();
       for(int i=0; i<arr.length; i++){
           pq.add(new int[]{i,arr[i]});
           while(pq.peek()[0]<=(i-k)){
               pq.poll();
           }
           if(i>=k-1) res.add(pq.peek()[1]);
       }
       return res;
    }
}
