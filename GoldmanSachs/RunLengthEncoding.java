class Solution {
    public static String encode(String str) {
        // code here
         int n=str.length();
          String res=""; int cnt=1;
          for(int i=1; i<n; i++){
                char c=str.charAt(i); 
                if(c==str.charAt(i-1)) cnt++;
                else{
                    res+=str.charAt(i-1);
                    res+=String.valueOf(cnt);
                    cnt=1;
                }
          }
          res+=str.charAt(n-1);
          res+=String.valueOf(cnt);
          return res;
    }
}
    