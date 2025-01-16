package Google;
import java.util.*;
class Solution {
    public int findTheCity(int n, int[][] edges, int dT) {
        int mat[][] = new int[n][n];
        for (int row[] : mat) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++)
            mat[i][i] = 0;

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            mat[u][v] = edge[2];
            mat[v][u] = edge[2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (mat[j][i] != Integer.MAX_VALUE && mat[i][k] != Integer.MAX_VALUE) {
                        mat[j][k] = Math.min(mat[j][k], mat[j][i] + mat[i][k]);
                    }
                }
            }
        }
        int res = -1; int cnt = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int curCnt = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j]<=dT) curCnt++;
            }
            if(curCnt<=cnt){
                cnt = curCnt;
                res = i;
            }
        }
        return res;
    }
}
