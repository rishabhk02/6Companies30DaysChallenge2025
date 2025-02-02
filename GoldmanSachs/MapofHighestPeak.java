import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int res[][] = new int[m][n];
        int vis[][] = new int[m][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    vis[i][j] = 1;
                    q.add(new int[] { i, j, 0 });
                }
            }
        }

        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur[] = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nI = cur[0] + dx[k], nJ = cur[1] + dy[k];
                    if(nI>=0 && nJ>=0 && nI<m && nJ<n && vis[nI][nJ]==0){
                        vis[nI][nJ]=1;
                        res[nI][nJ]=cur[2]+1;
                        q.add(new int[]{nI,nJ,res[nI][nJ]});
                    }
                }
            }
        }
        return res;
    }
}
