class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0; int cows=0; int n=secret.length();
        int digit1[] = new int[10];
        int digit2[] = new int[10];
        for(int i=0; i<n; i++){
            char c1=secret.charAt(i); char c2=guess.charAt(i);
            if(c1==c2){
                bulls++;
            }else{
                digit1[c1-'0']++;
                digit2[c2-'0']++;
            }
        }
        for(int i=0; i<10; i++){
            cows+=Math.min(digit1[i],digit2[i]);
        }

        String res = bulls+"A"+cows+"B";
        return res;
    }
}