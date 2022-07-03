import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem statement: https://leetcode.com/problems/single-number/
    // Refer explanation doc in root folder.

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println("Single Number: " + singleNumber_solution_1(new int[]{2, 2, 1}));
        System.out.println("Single Number: " + singleNumber_solution_1(new int[]{4, 1, 2, 1, 2}));
        System.out.println("Single Number: " + singleNumber_solution_1(new int[]{1}));

        System.out.println("Solution 2");
        System.out.println("Single Number: " + singleNumber_solution_2(new int[]{2, 2, 1}));
        System.out.println("Single Number: " + singleNumber_solution_2(new int[]{4, 1, 2, 1, 2}));
        System.out.println("Single Number: " + singleNumber_solution_2(new int[]{1}));
    }

    public static int singleNumber_solution_1(int[] nums) {

        // O(n) time | O(1) space
        // This solution takes almost constant time as it removes duplicate elements from the set.

        if (nums.length == 1) return nums[0];

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }

        return set.iterator().next();
    }

    public static int singleNumber_solution_2(int[] nums) {

        // O(n) time | O(1) space
        // Using Bit Manipulation

        int ans = 0;

        for (int num : nums) {
            ans = ans ^ num;
        }

        return ans;
    }
}
