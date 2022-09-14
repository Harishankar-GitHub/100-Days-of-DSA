import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/product-of-array-except-self/

    public static void main(String[] args) {
        System.out.println("Solution 1: Brute Force");
        System.out.println(Arrays.toString(productExceptSelf_bruteForce(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf_bruteForce(new int[]{-1, 1, 0, -3, 3})));

        System.out.println("Solution 2: Using left and right array");
        System.out.println(Arrays.toString(productExceptSelf_solution_2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf_solution_2(new int[]{-1, 1, 0, -3, 3})));

        System.out.println("Solution 3: Using only 1 array");
        System.out.println(Arrays.toString(productExceptSelf_solution_3(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf_solution_3(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf_bruteForce(int[] array) {

        // O(n^2) time | O(n) space
        // Brute Force

        int[] productExceptSelf = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int currentProduct = 1;
            for (int j = 0; j < array.length; j++) {
                if (j != i) currentProduct *= array[j];
            }
            productExceptSelf[i] = currentProduct;
        }

        return productExceptSelf;
    }

    public static int[] productExceptSelf_solution_2(int[] nums) {

        // O(n) time | O(n) space

        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];
        int[] productExceptSelf = new int[nums.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            leftArray[i] = leftRunningProduct;
            leftRunningProduct *= nums[i];
        }

        int rightRunningProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightArray[i] = rightRunningProduct;
            rightRunningProduct *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            productExceptSelf[i] = leftArray[i] * rightArray[i];
        }

        return productExceptSelf;
    }

    public static int[] productExceptSelf_solution_3(int[] nums) {

        // O(n) time | O(n) space

        int[] productExceptSelf = new int[nums.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            productExceptSelf[i] = leftRunningProduct;
            leftRunningProduct = leftRunningProduct * nums[i];
        }

        int rightRunningProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productExceptSelf[i] = productExceptSelf[i] * rightRunningProduct;
            rightRunningProduct = rightRunningProduct * nums[i];
        }

        return productExceptSelf;
    }
}
