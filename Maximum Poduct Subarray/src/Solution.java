public class Solution {

    // Problem statement: https://leetcode.com/problems/maximum-product-subarray/

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(maxProduct_solution_1(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct_solution_1(new int[]{-2, 0, -1}));
        System.out.println(maxProduct_solution_1(new int[]{0, 2}));

        System.out.println("Solution 2");
        System.out.println(maxProduct_solution_2(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct_solution_2(new int[]{-2, 0, -1}));
        System.out.println(maxProduct_solution_2(new int[]{0, 2}));
    }

    public static int maxProduct_solution_1(int[] nums) {

        // O(n) time | O(1) space

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

    public static int maxProduct_solution_2(int[] nums) {

        // O(n) time | O(1) space

        int length = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int maxProductSoFar = nums[0];

        for (int i = 0; i < length; i++) {
            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[length - i - 1];

            maxProductSoFar = Math.max(maxProductSoFar, Math.max(leftProduct, rightProduct));

            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
        }

        return maxProductSoFar;
    }
}
