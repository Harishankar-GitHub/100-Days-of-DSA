import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Problem statement: https://leetcode.com/problems/climbing-stairs/

    public static void main(String[] args) {
        System.out.println("Using Recursion");
        System.out.println(climbStairs_recursion(2));
        System.out.println(climbStairs_recursion(3));

        System.out.println("Using Recursion + Memoization - 1");
        System.out.println(climbStairs_memoization_1(2));
        System.out.println(climbStairs_memoization_1(3));

        System.out.println("Using Recursion + Memoization - 2");
        System.out.println(climbStairs_memoization_2(2));
        System.out.println(climbStairs_memoization_2(3));

        System.out.println("Using Tabulation");
        System.out.println(climbStairs_tabulation(2));
        System.out.println(climbStairs_tabulation(3));

        System.out.println("Using Space Optimization");
        System.out.println(climbStairs_space_optimization(2));
        System.out.println(climbStairs_space_optimization(3));
    }

    public static int climbStairs_recursion(int n) {
        // Works but time limit exceeds
        // O(n) time | O(n) space

        // Base case
        if (n <= 1) return 1;

        // Recursive relation
        return climbStairs_recursion(n-1) + climbStairs_recursion(n-2);
    }

    public static int climbStairs_memoization_1(int n) {
        // O(n) time | O(n) space

        Map<Integer, Integer> memoize = new HashMap<>();
        return climbStairs_memoization_1(n, memoize);
    }

    private static int climbStairs_memoization_1(int n, Map<Integer, Integer> map) {
        // Base case
        if (n <= 1) return 1;

        if (map.containsKey(n)) return map.get(n);

        // Recursive relation
        map.put(n, climbStairs_memoization_1(n-1, map) + climbStairs_memoization_1(n-2, map));
        return map.get(n);
    }

    public static int climbStairs_memoization_2(int n) {
        // O(n) time | O(n) space

        int[] dpArr = new int[n+1];
        Arrays.fill(dpArr, -1);

        return climbStairs_memoization_2(n, dpArr);
    }

    private static int climbStairs_memoization_2(int n, int[] dpArr) {
        // Base case
        if (n <= 1) return 1;

        if (dpArr[n] != -1) return dpArr[n];

        // Recursive relation
        dpArr[n] = climbStairs_memoization_2(n-1, dpArr) + climbStairs_memoization_2(n-2, dpArr);
        return dpArr[n];
    }

    public static int climbStairs_tabulation(int n) {
        // O(n) time | O(n) space

        int[] dpArr = new int[n+1];
        dpArr[0] = 1;
        dpArr[1] = 1;

        for (int i = 2; i <= n; i++) {
            dpArr[i] = dpArr[i-1] + dpArr[i-2];
        }

        return dpArr[n];
    }

    public static int climbStairs_space_optimization(int n) {
        // O(n) time | O(1) space

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
