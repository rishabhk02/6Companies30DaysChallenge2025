package Amazon;
class Node{
    Node prev;
    Node next;
}

class Solution {
    static void linkdelete(Node head, int n, int m) {
        if(n==0) return;
        Node prev = null; Node cur = head;
        int skip = 0, del = 0;
        while(cur!=null){
            skip=0; del=0;
            while(cur!=null && skip<m){
                skip++;
                if(prev!=null){
                    prev.next = cur;
                }
                prev = cur;
                cur = cur.next;
            }
            if(prev!=null) prev.next = null;
            while(cur!=null && del<n){
                del++;
                cur = cur.next;
            }
        }
    }
}
