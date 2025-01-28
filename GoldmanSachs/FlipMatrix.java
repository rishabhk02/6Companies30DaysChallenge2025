package GoldmanSachs;
import java.util.*;

class Solution {
    int rows, cols, total;
    Map<Integer, Integer> flipped;
   public Solution(int m, int n) {
       rows = m;
       cols = n;
       total = rows * cols;
       flipped = new HashMap<>();
   }

   public int[] flip() {
           Random rand=new Random();
       int r = rand.nextInt(total--);
       int x = flipped.getOrDefault(r, r);
       flipped.put(r, flipped.getOrDefault(total, total));
       return new int[]{x / cols, x % cols};
   }

   public void reset() {
       total = rows * cols;
       flipped.clear();
   }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(m, n);
* int[] param_1 = obj.flip();
* obj.reset();
*/