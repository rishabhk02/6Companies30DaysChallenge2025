class Solution {
    int dp[][];
    public int maxProduct(String s) {
        int n=s.length(); int mask=1<<n;
        int res=0; dp=new int[13][13];

        for(int i=0; i<mask; i++){
            StringBuilder s1=new StringBuilder();
            StringBuilder s2=new StringBuilder();
            for(int j=0; j<n; j++){
                char c=s.charAt(j);
                if((i&1<<j)!=0){
                    s1.append(c);
                }else s2.append(c);
            }            
            for(int row[]: dp) Arrays.fill(row,-1);
            int l1=helper(0,s1.length()-1,s1);

            for(int row[]: dp) Arrays.fill(row,-1);
            int l2=helper(0,s2.length()-1,s2);

            res=Math.max(res,l1*l2);
        }
        return res;
    }

    int helper(int i, int j, StringBuilder s){
        if(i>j) return 0;
        if(i==j) return 1;
        if(i+1==j){
            return (s.charAt(i)==s.charAt(j))?2:1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+helper(i+1,j-1,s);
        }else{
            return dp[i][j]=Math.max(helper(i+1,j,s),helper(i,j-1,s));
        }
    }
}