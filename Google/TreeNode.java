package Google;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int ans = 0;

    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return ans;
    }

    int[] helper(TreeNode root, int dist) {
        int res[] = new int[dist + 1];
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res[1] = 1;
            return res;
        }
        int l[] = helper(root.left, dist);
        int r[] = helper(root.right, dist);
        for (int i = 0; i <= dist; i++) {
            for (int j = 0; j <= dist; j++) {
                if (i + j <= dist) {
                    ans += (l[i] * r[j]);
                }
            }
        }
        for (int i = 0; i < dist; i++) {
            res[i + 1] = l[i] + r[i];
        }
        return res;
    }
}
