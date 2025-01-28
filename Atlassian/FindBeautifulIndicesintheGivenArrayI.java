import java.util.*;

 class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int m=s.length(); int n=a.length(); int o=b.length();
        int bLast=-1;
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> not = new ArrayList<>();
        for(int i=0; i<m; i++){
            if(i+n<=m && s.substring(i,i+n).equals(a)){
                if(bLast!=-1 && i-k<=bLast){
                    set.add(i);
                }else{
                    not.add(i);
                }
            }
            if(i+o<=m && s.substring(i,i+o).equals(b)){
                bLast=i;
                ArrayList<Integer> rmv = new ArrayList<>();
                for(int val: not){
                    if(i-val<=k){
                        rmv.add(val);
                        set.add(val);
                    }
                }
                for(int val: rmv){
                    not.remove(Integer.valueOf(val));
                }
            }
            
        }
        return new ArrayList<>(set);
    }
}