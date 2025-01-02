import java.util.*;

class Solution {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    Random rand = new Random();
    int rects[][]; int totSum=0;

    public Solution(int[][] rects) {
        this.rects=rects;
        for(int i=0; i<rects.length; i++){
            map.put(totSum,i);
            totSum+=calcW(rects[i])*calcH(rects[i]);
        }
    }
    
    public int[] pick() {
        int point = rand.nextInt(totSum);
        var florK = map.floorEntry(point);
        int pOnRect = point-florK.getKey();
        int rect[] = rects[florK.getValue()];
        return new int[]{
            rect[0]+pOnRect/calcH(rect),
            rect[1]+pOnRect%calcH(rect)
        };
    }

    int calcW(int rect[]){
        return rect[2]-rect[0]+1;
    }
    int calcH(int rect[]){
        return rect[3]-rect[1]+1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */