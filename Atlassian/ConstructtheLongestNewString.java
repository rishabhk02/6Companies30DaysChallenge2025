class Solution {
    public int longestString(int x, int y, int z) {
        if(x==y){
            return (x+y+z)*2;
        }
        return (Math.min(x,y)*2+1+z)*2;
    }
}