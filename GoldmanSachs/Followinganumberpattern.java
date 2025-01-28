package GoldmanSachs;
import java.util.*;

//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        Stack<Integer> st = new Stack<>();
        int num=1; int n=S.length(); StringBuilder res = new StringBuilder();
        for(int i=0; i<n; i++){
            st.push(num++);
            if(S.charAt(i)=='I'){
                while(!st.isEmpty()){
                    res.append(st.pop());
                }
            }
        }
        if(S.charAt(n-1)=='I') res.append(num);
        else{
            st.push(num);
            while(!st.isEmpty()){
                res.append(st.pop());
            }
        }
        return res.toString();
    }
}