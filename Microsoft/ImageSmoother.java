class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m=img.length; int n=img[0].length;
        int dx[] = {-1,-1,-1,1,1,1,0,0};
        int dy[] = {-1,0,1,-1,0,1,-1,1};
        int res[][]=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum=img[i][j]; int con=1;
                for(int k=0; k<8; k++){
                    int r=i+dx[k]; int c=j+dy[k];
                    if(r>=0 && c>=0 && r<m && c<n){
                        sum+=img[r][c]; con++;
                    }
                }
                sum/=con;
                res[i][j]=sum;
            }
        }

        return res;
    }
}