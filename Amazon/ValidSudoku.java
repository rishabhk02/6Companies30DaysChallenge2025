package Amazon;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int arr[] = new int[10];
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.') continue;
                arr[board[i][j] - '1']++;
                if (arr[board[i][j] - '1'] > 1)
                    return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            int arr[] = new int[10];
            for (int i = 0; i < 9; i++) {
                if(board[i][j]=='.') continue;
                arr[board[i][j] - '1']++;
                if (arr[board[i][j] - '1'] > 1)
                    return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int arr[] = new int[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int x = i + k;
                        int y = j + l;
                        if(board[x][y]=='.') continue;
                        arr[board[x][y] - '1']++;
                        if (arr[board[x][y] - '1'] > 1)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}