package Google;
import java.util.*;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] aster) {
        long m=mass*1l;
        Arrays.sort(aster);
        for(int i=0; i<aster.length; i++){
            if(m<aster[i]) return false;
            m+=aster[i];
        }
        return true;
    }
}
