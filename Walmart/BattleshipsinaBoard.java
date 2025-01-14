package Walmart;

import java.util.*;
class Solution {
    public int countBattleships(char[][] board) {
        int n=board.length; int m=board[0].length;
        int res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='X'){
                    res++; helper(i,j,board);
                }
            }
        }
        return res;
    }

    void helper(int r, int c, char board[][]){
        board[r][c]='.'; int n=board.length; int m=board[0].length;
        ArrayDeque<int[]>q=new ArrayDeque<>();
        q.add(new int[]{r,c});
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int k=0; k<4; k++){
                int row=cur[0]+dx[k]; int col=cur[1]+dy[k];
                if(row>=0 && col>=0 && row<n && col<m && board[row][col]=='X'){
                    board[row][col]='.'; q.add(new int[]{row,col});
                }
            }
        }
        return;
    }
}
