package Amazon;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null)
            return "-1001";
        str.append(root.val);
        DFS(root.left, str);
        DFS(root.right, str);
        return str.toString();
    }

    void DFS(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("," + -1001);
            return;
        }
        str.append("," + root.val);
        DFS(root.left, str);
        DFS(root.right, str);
        return;
    }

    // Decodes your encoded data to tree.
    int idx;

    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        if (Integer.parseInt(arr[0]) == -1001)
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        idx = 1;
        root.left = helper(arr);
        root.right = helper(arr);
        return root;
    }

    TreeNode helper(String arr[]) {
        int v = Integer.parseInt(arr[idx++]);
        if (v == -1001)
            return null;
        TreeNode root = new TreeNode(v);
        root.left = helper(arr);
        root.right = helper(arr);
        return root;
    }
}
