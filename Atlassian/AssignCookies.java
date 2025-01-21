import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);
        int gi=0; int res=0;
        for(int i=0; i<s.length && gi<g.length; i++){
            if(s[i]>=g[gi]){
                res++; gi++;
            }
        }
        return res;
    }
}