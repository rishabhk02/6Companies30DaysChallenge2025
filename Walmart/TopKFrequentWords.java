package Walmart;

import java.util.*;

class Solution {
    class TrieNode {
        boolean isEnd; int freq;
        TrieNode list[];
        TrieNode(){
            isEnd=false; freq=0;
            list=new TrieNode[26];            
        }
    }

    TrieNode root = new TrieNode();

    void add(String str){
        int n=str.length();
        TrieNode cur = root;
        for(int i=0; i<n; i++){
            char c=str.charAt(i);
            if(cur.list[c-'a']==null){
                cur.list[c-'a']=new TrieNode();
            }
            cur=cur.list[c-'a'];
        }
        cur.isEnd=true; cur.freq+=1;
    }

    class Data implements Comparable<Data>{
        String str; int count;
        Data(String str, int count){
            this.str=str; this.count=count;
        }
        public int compareTo(Data a){
            if(a.count!=this.count){
                return Integer.compare(a.count,this.count);
            }
            return (this.str).compareTo(a.str);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        for(int i=0; i<words.length; i++){
            add(words[i]);
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        PriorityQueue<Data> pq = new PriorityQueue<>();
        for(String s: set){
            pq.add(new Data(s,getF(s)));
        }
        List<String> res = new LinkedList<>();
        while(k-->0 && !pq.isEmpty()){
            res.add(pq.poll().str);
        }

        return res;
    }

    int getF(String str){
        int n=str.length();
        TrieNode cur = root;
        for(int i=0; i<n; i++){
            char c=str.charAt(i);
            cur=cur.list[c-'a'];
        }
        return cur.freq; 
    }
}