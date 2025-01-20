package Google;
import java.util.*;

class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;    
        int cnt = getCount(grid);
        if(cnt==2 || cnt==0) return 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    grid[i][j] = 0;
                    cnt = getCount(grid);
                    if(i==1 && j==2){
                        System.out.println(cnt);
                    }
                    if(cnt==2 || cnt==0) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};

    int getCount(int grid[][]){
        int m = grid.length; 
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++; 
                    if(cnt==2) return 2;
                    BFS(i,j,m,n,grid,vis);
                }
            }
        }
        return cnt;
    }

    void BFS(int i, int j, int m, int n, int grid[][], int vis[][]){
        vis[i][j] = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int arr[] = q.poll();
            for(int k=0; k<4; k++){
                int nI=arr[0]+dx[k];
                int nJ=arr[1]+dy[k];
                if(nI>=0 && nI<m && nJ>=0 && nJ<n && grid[nI][nJ]==1 && vis[nI][nJ]==0){
                    vis[nI][nJ]=1;
                    q.add(new int[]{nI,nJ});
                }
            }
        }
        return;
    }
}