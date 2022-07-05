import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Problem statement: https://leetcode.com/problems/3sum/

    public static void main(String[] args) {
        List<List<Integer>> threeNumberSum = threeSum(new int[]{-1,0,1,2,-1,-4});

        for (List<Integer> list : threeNumberSum) {
            list.forEach(System.out::print);
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;

            while (start < end) {
                int currentNum = nums[i];
                int secondNum = nums[start];
                int thirdNum = nums[end];

                int sum = currentNum + secondNum + thirdNum;

                if (sum == 0) {
                    triplets.add(List.of(currentNum, secondNum, thirdNum));
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return triplets;
    }
}
