package Google;

class WordDictionary {
    class Trie{
        boolean flag=false;
        Trie[] arr = new Trie[26];
    }
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie cur = root;
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            if(cur.arr[c-'a']==null){
                cur.arr[c-'a']=new Trie();
            }
            cur=cur.arr[c-'a'];
        }
        cur.flag=true;
    }

    boolean search(String word, int i, Trie cur){
        for(int j=i; j<word.length(); j++){
            char c=word.charAt(j);
            if(c=='.'){
                for(int k=0; k<26; k++){
                    if(cur.arr[k]!=null){
                        if(search(word,j+1,cur.arr[k])) return true;
                    }
                }
                return false;
            }else{
                if(cur.arr[c-'a']==null) return false;
                cur=cur.arr[c-'a'];
            }
        }
        return cur.flag;
    }
    
    public boolean search(String word) {
        return search(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */