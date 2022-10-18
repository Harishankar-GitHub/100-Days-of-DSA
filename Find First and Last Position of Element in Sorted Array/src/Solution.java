import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static void main(String[] args) {
        System.out.println("Solution 1 - My Solution");
        System.out.println(Arrays.toString(searchRange_my_solution(new int[]{5, 7, 7, 8, 8, 10}, 8)));  // [3, 4]
        System.out.println(Arrays.toString(searchRange_my_solution(new int[]{5, 7, 7, 8, 8, 10}, 6))); // [-1, -1]
        System.out.println(Arrays.toString(searchRange_my_solution(new int[]{}, 0))); // [-1, -1]
        System.out.println(Arrays.toString(searchRange_my_solution(new int[]{1, 4}, 4))); // [1, 1]

        System.out.println("Solution 2");
        System.out.println(Arrays.toString(searchRange_solution_2(new int[]{5, 7, 7, 8, 8, 10}, 8)));  // [3, 4]
        System.out.println(Arrays.toString(searchRange_solution_2(new int[]{5, 7, 7, 8, 8, 10}, 6))); // [-1, -1]
        System.out.println(Arrays.toString(searchRange_solution_2(new int[]{}, 0))); // [-1, -1]
        System.out.println(Arrays.toString(searchRange_solution_2(new int[]{1, 4}, 4))); // [1, 1]
    }

    public static int[] searchRange_my_solution(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return new int[]{0, 0};

        int targetIndex = searchTargetInNums(nums, target, 0, nums.length); // Binary Search

        if (targetIndex == -1) return new int[]{-1, -1};

        int[] positions = new int[2];
        int left = targetIndex;
        int right = targetIndex;

        while (left >= 0) {
            if (nums[left] == target) positions[0] = left;
            left--;
        }

        while (right <= nums.length - 1) {
            if (nums[right] == target) positions[1] = right;
            right++;
        }

        return positions;
    }

    public static int[] searchRange_solution_2(int[] nums, int target) {
        int leftIndex = findLeft(nums, target);
        int rightIndex = findRight(nums, target);

        return new int[]{leftIndex, rightIndex};
    }

    private static int searchTargetInNums(int[] nums, int target, int start, int end) {
        if (start >= end) return -1;

        int mid = (start + end) / 2;
        int valueAtMid = nums[mid];

        if (valueAtMid == target) return mid;
        else if (valueAtMid < target) return searchTargetInNums(nums, target, mid+1, end);
        else return searchTargetInNums(nums, target, start, mid);
    }

    private static int findLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int leftIndex = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int valueAtMid = nums[mid];

            if (valueAtMid < target) {
                start = mid + 1;
            } else if (valueAtMid > target) {
                end = mid - 1;
            } else {
                leftIndex = mid;
                end = mid - 1;
            }
        }

        return leftIndex;
    }

    private static int findRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int rightIndex = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int valueAtMid = nums[mid];

            if (valueAtMid < target) {
                start = mid + 1;
            } else if (valueAtMid > target) {
                end = mid - 1;
            } else {
                rightIndex = mid;
                start = mid + 1;
            }
        }

        return rightIndex;
    }
}