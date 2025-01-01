class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int minX=Math.max(x1,Math.min(xCenter,x2));
        int minY=Math.max(y1,Math.min(yCenter,y2));
        int dist=(minX-xCenter)*(minX-xCenter)+(minY-yCenter)*(minY-yCenter);
        if(dist<=radius*radius) return true;
        return false;
    }
}