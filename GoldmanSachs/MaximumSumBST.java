class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    int res=0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return res;
    }

    int[] helper(TreeNode root){
        if(root==null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        
        if(left[2]==Integer.MIN_VALUE || right[2]==Integer.MIN_VALUE || left[1]>=root.val || right[0]<=root.val){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        }
        res=Math.max(res,left[2]+right[2]+root.val);
        return new int[]{Math.min(root.val,left[0]),Math.max(root.val,right[1]),left[2]+right[2]+root.val};
    }
}
