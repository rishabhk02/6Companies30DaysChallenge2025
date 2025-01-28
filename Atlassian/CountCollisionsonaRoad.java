import java.util.*;

class Solution {
    public int countCollisions(String dir) {
        char prev=dir.charAt(0); int res=0; int n=dir.length();
        Stack<Character> st = new Stack<>(); st.add(prev);
        for(int i=1; i<n; i++){
            char c=dir.charAt(i);
            if(c=='L'){
                boolean flag=false;
                while(!st.isEmpty() && st.peek()=='R'){
                    st.pop(); 
                    if(flag==false){
                        res+=2; flag=true; 
                    }else res+=1;
                }
                if(flag==false && !st.isEmpty() && st.peek()=='S'){
                    res+=1; flag=true;
                }
                if(flag==false){
                    st.push(c);
                }else{
                    st.push('S'); 
                }
            }else if(c=='R'){
               st.push(c);
            }else{
                while(!st.isEmpty() && st.peek()=='R'){
                    res+=1; st.pop();
                }
                st.push(c);
            }
        }
        return res;
    }
}