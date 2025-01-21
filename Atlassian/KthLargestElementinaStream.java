import java.util.*;

class KthLargest {
    ArrayList<Integer> arr; int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        arr = new ArrayList<>();
        for(int v: nums) arr.add(v);
        Collections.sort(arr);
    }
    
    public int add(int val) {
        int n = arr.size();
        int low = 0; int high = n-1; int res = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr.get(mid)>val){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(res!=n) arr.add(res,val);
        else arr.add(val);
        return arr.get(n+1-k);
    }
}