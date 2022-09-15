import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/sort-colors/

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
        sortColors(new int[]{2, 0, 1});
    }

    public static void sortColors(int[] nums) {

        // O(n) time | O(1) space
        
        int[] order = new int[]{0, 1, 2};

        int currentIndexToBeSorted = 0;

        for (int currentNumInOrder : order) {
            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];

                if (currentNum == currentNumInOrder) {
                    swap(nums, i, currentIndexToBeSorted);
                    currentIndexToBeSorted++;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
