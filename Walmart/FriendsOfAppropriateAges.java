package Walmart;
class Solution {
    public int numFriendRequests(int[] ages) {
        int freq[] = new int[121];
        for(int v: ages){
            freq[v]++;
        }
        int pref[]=new int[121];
        for(int i=1; i<121; i++){
            pref[i]=pref[i-1]+freq[i];
        }
        int res=0;
        for(int i=15; i<121; i++){
            if(freq[i]==0) continue;
            int count = pref[i]-pref[i/2+7];
            res+=(count*freq[i]-freq[i]);
        }
        return res;
    }
}
