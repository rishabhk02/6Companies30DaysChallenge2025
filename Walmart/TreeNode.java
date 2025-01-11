package Walmart;

import java.util.*;

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
    int max = (int) 1e5 + 1;
    HashMap<TreeNode, TreeNode> map;
    TreeNode src;

    public int amountOfTime(TreeNode root, int start) {
        map = new HashMap<>();
        if (root.val == start) {
            src = root;
        }
        findPar(root.left, root, start);
        findPar(root.right, root, start);
        int res = -1;
        int vis[] = new int[max];
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(src);
        vis[start] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null && vis[cur.left.val] == 0) {
                    q.add(cur.left);
                    vis[cur.left.val] = 1;
                }
                if (cur.right != null && vis[cur.right.val] == 0) {
                    q.add(cur.right);
                    vis[cur.right.val] = 1;
                }
                if (map.containsKey(cur)) {
                    TreeNode par = map.get(cur);
                    if (vis[par.val] == 0) {
                        vis[par.val] = 1;
                        q.add(par);
                    }
                }
            }
        }
        return res;
    }

    void findPar(TreeNode root, TreeNode par, int start) {
        if (root == null)
            return;
        map.put(root, par);
        if (root.val == start) {
            src = root;
        }
        findPar(root.left, root, start);
        findPar(root.right, root, start);
    }
}