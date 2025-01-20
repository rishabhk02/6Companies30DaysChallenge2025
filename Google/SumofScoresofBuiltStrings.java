package Google;

class Solution {
    public long sumScores(String s) {
        int n=s.length();
        int lps[] = new int[n];
        buildLPS(lps,s,n);
        long res=0l;
        int count[] = new int[n+1];
        for(int i=0; i<n; i++){
            if(lps[i]!=0){
                count[i]=count[lps[i]-1]+1;
            }
        }
        for(int i: count) res+=i;
        return res+n;
    }

    void buildLPS(int lcs[], String s, int n){
        int idx=1; int len=0;
        while(idx<n){
            char c=s.charAt(idx);
            if(c==s.charAt(len)){
                lcs[idx++]=++len;
            }else{
                if(len==0) idx++;
                else{
                    len=lcs[len-1];
                }
            }
        }
        return;
    }
}