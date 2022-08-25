public class Solution {

    // Problem statement: https://leetcode.com/problems/jump-game/

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(canJump_solution_1(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump_solution_1(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump_solution_1(new int[]{2, 0, 0}));

        System.out.println("Solution 2");
        System.out.println(canJump_solution_2(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump_solution_2(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump_solution_2(new int[]{2, 0, 0}));
    }

    public static boolean canJump_solution_1(int[] nums) {
        // O(n) time } O(1) space

        if (nums.length == 1) return true;

        int maxReachableIndex = nums[0];
        int i = 1;

        while (i < nums.length && i <= maxReachableIndex) {
            int nextPosition = i + nums[i];
            if (nextPosition > maxReachableIndex) maxReachableIndex = nextPosition;
            i++;
        }

        return maxReachableIndex >= nums.length - 1;
    }

    public static boolean canJump_solution_2(int[] nums) {
        // O(n) time } O(1) space

        if (nums.length == 1) return true;

        int maxReachableIndex = nums[0];

        for (int i = 1; i < nums.length - 1 && i <= maxReachableIndex; i++) {
            int nextPosition = i + nums[i];
            if (nextPosition > maxReachableIndex) maxReachableIndex = nextPosition;
        }

        return maxReachableIndex >= nums.length - 1;
    }
}
