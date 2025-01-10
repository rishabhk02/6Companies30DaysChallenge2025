package Amazon;
import java.util.*;

class Solution {
    class Pair{
        int i,j;
        Pair(int i, int j){this.i=i; this.j=j;};
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length; int n=grid[0].length;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        int minutes=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair cur=q.poll(); int i=cur.i; int j=cur.j;
                for(int k=0; k<4; k++){
                    int nI=i+dx[k]; int nJ=j+dy[k];
                    if(nI>=0 && nI<m && nJ>=0 && nJ<n && grid[nI][nJ]==1){
                        grid[nI][nJ]=2;
                        q.add(new Pair(nI,nJ));
                    }
                }
            }
            if(q.size()>0) minutes++;
        }

        for(int i=0; i<m; i++){for(int j=0; j<n; j++){if(grid[i][j]==1){return -1;}}}

        return minutes;
    }
}
