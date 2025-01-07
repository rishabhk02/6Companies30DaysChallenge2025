package Amazon;
import java.util.*;

class Solution{
    static class TrieNode{
        Map<Character,Set<String>> list;
        TrieNode []next;
        TrieNode(){
            list = new HashMap<>();
            next = new TrieNode[26];
        }
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        TrieNode head = new TrieNode();
        for(String st: contact){
            TrieNode curr = head;
            for(char c: st.toCharArray()){
                int index = c-'a';
                curr.list.putIfAbsent(c,new TreeSet<>());
                curr.list.get(c).add(st);
                if(curr.next[index]==null) curr.next[index]=new TrieNode();
                curr=curr.next[index];
            }
        }
        

        TrieNode curr = head;
        for(char c: s.toCharArray()){
            ArrayList<String> curList = new ArrayList<>();
            if(curr.list.containsKey(c)){
                curList.addAll(curr.list.get(c));
            }
            if(curList.size()==0) curList.add("0");
            ans.add(curList);
            if(curr.next[c-'a']!=null){
                curr=curr.next[c-'a'];
            }else{
                break;
            }
        }
        while(ans.size()!=s.length()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("0");
            ans.add(temp);
        }
        
        return ans;
    }
}
