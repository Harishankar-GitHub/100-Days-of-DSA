public class Solution {

    // Problem statement: https://leetcode.com/problems/maximum-product-subarray/

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{0, 2}));
    }

    public static int maxProduct(int[] nums) {

        // O(n) time | O(n) space

        if (nums.length == 1) return nums[0];

        int maxSoFar = 0;

        int currentProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (currentNum != 0) {
                currentProduct = currentProduct * currentNum;
                maxSoFar = Math.max(currentProduct, maxSoFar);
            } else {
                currentProduct = 1;
            }
        }

        currentProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int currentNum = nums[i];
            if (currentNum != 0) {
                currentProduct = currentProduct * currentNum;
                maxSoFar = Math.max(currentProduct, maxSoFar);
            } else {
                currentProduct = 1;
            }
        }

        return maxSoFar;
    }
}
