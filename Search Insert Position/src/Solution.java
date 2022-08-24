import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/search-insert-position/

    public static void main(String[] args) {
        System.out.println("My solution");
        System.out.println(searchInsert_my_solution(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert_my_solution(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert_my_solution(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert_my_solution(new int[]{1, 3}, 2));

        System.out.println("More optimized");
        System.out.println(searchInsert_more_optimized(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert_more_optimized(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert_more_optimized(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert_more_optimized(new int[]{1, 3}, 2));
    }

    public static int searchInsert_my_solution(int[] nums, int target) {

        // O(logn) time | O(1) space

        int targetIndex = Arrays.binarySearch(nums, target);

        if (targetIndex >= 0) return targetIndex;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }

        return nums.length;
    }

    public static int searchInsert_more_optimized(int[] nums, int target) {

        // O(logn) time | O(1) space

        int ans = nums.length;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
