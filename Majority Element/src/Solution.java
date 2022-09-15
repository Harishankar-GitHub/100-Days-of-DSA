public class Solution {

    // Problem statement: https://leetcode.com/problems/majority-element/

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {

        // O(n) time | O(1) space

        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }
}
