package Walmart;

class Solution {
    class Node{
        int val; Node left; Node right;
        Node(int val, Node left, Node right){
            this.val=val; this.left=left; this.right=right;
        }
    } 

    int idx=0;

    public boolean isValidSerialization(String pre) {
        String str[] = pre.split(",");
        int n = str.length;
        Node root = create(str,n);
        if(idx<n) return false;
        return verify(root);
    }

    boolean verify(Node root){
        if(root.val==-1) return true;
        if(root.left==null || root.right==null) return false;
        boolean res = true;
        if(root.left.val!=-1){
            res &= verify(root.left);
        }
        if(root.right.val!=-1){
            res &= verify(root.right);
        }
        return res;
    }

    Node create(String str[], int n){
        if(idx>=n) return null;
        String cur = str[idx++];
        if(cur.equals("#")){
            return new Node(-1,null,null);
        }
        int digit=Integer.parseInt(cur);
        Node root = new Node(digit,null,null);
        root.left = create(str,n);
        root.right = create(str,n);
        return root;
    }
}
