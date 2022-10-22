public class Solution {

    // Problem statement: https://leetcode.com/problems/search-in-rotated-sorted-array/

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));    // 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));    // -1
        System.out.println(search(new int[]{1}, 0));    // -1
    }

    public static int search(int[] nums, int target) {
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
}