import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Problem statement: https://leetcode.com/problems/binary-tree-inorder-traversal/
    // In order traversal: First process left subtree, then process current node, and then right subtree.

    public static void main(String[] args) {
        TreeNode root = buildTreeNode();

        List<Integer> inorderTraversal = inorderTraversal(root);
        inorderTraversal.forEach(System.out::println);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // O(n) time | O(1) space

        List<Integer> inorderTraversal = new ArrayList<>();
        inOrder(root, inorderTraversal);
        return inorderTraversal;
    }

    private static void inOrder(TreeNode node, List<Integer> inorderTraversal) {
        if (node != null) {
            inOrder(node.left, inorderTraversal);
            inorderTraversal.add(node.val);
            inOrder(node.right, inorderTraversal);
        }
    }

    private static TreeNode buildTreeNode() {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        root.right = two;
        two.left = three;

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
