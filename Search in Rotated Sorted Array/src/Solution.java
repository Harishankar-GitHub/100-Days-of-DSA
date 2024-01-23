public class Solution {

    // Problem statement: https://leetcode.com/problems/search-in-rotated-sorted-array/

    public static void main(String[] args) {
        System.out.println("Search Solution 1");
        System.out.println(search_solution_1(new int[]{4,5,6,7,0,1,2}, 0));    // 4
        System.out.println(search_solution_1(new int[]{4,5,6,7,0,1,2}, 3));    // -1
        System.out.println(search_solution_1(new int[]{1}, 0));    // -1

        System.out.println("Search Solution 2");
        System.out.println(search_solution_2(new int[]{4,5,6,7,0,1,2}, 0));    // 4
        System.out.println(search_solution_2(new int[]{4,5,6,7,0,1,2}, 3));    // -1
        System.out.println(search_solution_2(new int[]{1}, 0));    // -1
    }

    public static int search_solution_1(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int firstNum = nums[0];
            int middleNum = nums[mid];

            if (middleNum >= firstNum && target < firstNum) {
                start = mid + 1;
            } else if (middleNum < firstNum && target >= firstNum) {
                end = mid - 1;
            } else {    // Usual Binary Search
                if (middleNum < target) {
                    start = mid + 1;
                } else if (middleNum > target) {
                    end = mid - 1;
                } else {
                    ans = mid;
                    break;
                }
            }
        }

        return ans;
    }

    public static int search_solution_2(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        // This while loop is to find out the index of minimum number in the array.
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int indexOfMinimumNumber = left;
        left = 0;
        right = nums.length - 1;

        // This condition is to find out whether to search in left half of the array or to the right.
        if (target >= nums[indexOfMinimumNumber] && target <= nums[right]) {
            left = indexOfMinimumNumber;
        } else {
            right = indexOfMinimumNumber;
        }

        // After finding out which half of the array to search, the below code is usual binary search to search through the array.
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}