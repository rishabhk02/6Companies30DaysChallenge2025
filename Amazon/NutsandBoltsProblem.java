package Amazon;
import java.util.*;

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
       String order = "!#$%&*?@^";
        Character[] nutsArr = new Character[n];
        Character[] boltsArr = new Character[n];
        
        for (int i = 0; i < n; i++) {
            nutsArr[i] = nuts[i];
            boltsArr[i] = bolts[i];
        }

        Arrays.sort(nutsArr, (a, b) -> Integer.compare(order.indexOf(a), order.indexOf(b)));
        Arrays.sort(boltsArr, (a, b) -> Integer.compare(order.indexOf(a), order.indexOf(b)));

        for (int i = 0; i < n; i++) {
            nuts[i] = nutsArr[i];
            bolts[i] = boltsArr[i];
        }
    }
}
