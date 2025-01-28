package GoldmanSachs;

import java.util.*;

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> at) {
        int n=at.size();
        HashMap<String,ArrayList<int[]>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String name=at.get(i).get(0);
            Integer hr=Integer.parseInt(at.get(i).get(1).substring(0,2));
            Integer mn=Integer.parseInt(at.get(i).get(1).substring(2));
            map.putIfAbsent(name,new ArrayList<>());
            map.get(name).add(new int[]{hr,mn});
        }

        List<String> res = new ArrayList<>();
        for(String key: map.keySet()){
            ArrayList<int[]> time = map.get(key);
            Collections.sort(time,new Comparator<int[]>(){
                public int compare(int a[], int b[]){
                    if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
                    return Integer.compare(a[1],b[1]);
                }
            });
        
            for(int i=2; i<time.size(); i++){
                int prev[] = time.get(i-2);
                if(prev[0]==time.get(i)[0]){
                    res.add(key);
                    break;
                }else if(prev[0]==time.get(i)[0]-1){
                    int min=60-prev[1]+time.get(i)[1];
                    if(min<60){
                        res.add(key);
                        break;
                    }
                }
            }
        }

        return res;        
    }
}