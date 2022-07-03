import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        // O(n) time | O(1) space

        int start = 0;
        int end = numbers.length-1;

        while (start <= end) {
            int sum = numbers[start]+numbers[end];

            if (target == sum) return new int[]{start+1, end+1};

            else if (target < sum) end-=1;

            else start+=1;
        }

        return new int[]{-1, -1};
    }
}
