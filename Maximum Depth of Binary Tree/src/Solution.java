public class Solution {

    // Problem statement: https://leetcode.com/problems/maximum-depth-of-binary-tree/

    public static void main(String[] args) {
        TreeNode root = buildTreeNode();

        System.out.println("Max depth: " + maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftNodeDepth = maxDepth(root.left) + 1;
        int rightNodeDepth = maxDepth(root.right) + 1;

        return Math.max(leftNodeDepth, rightNodeDepth);
    }

    private static TreeNode buildTreeNode() {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        root.left = nine;
        root.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        return root;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
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
}
