import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/coin-change/

    // Note:
    // Greedy approach (starting from big denominations) will not work here.
    // Because, Amount = 18
    // Coins = 1, 9, 16
    // Greedy approach = 16 + 1 + 1 = 18 (3 coins used)
    // Answer: 9 + 9 = 18 (2 coins used)

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.printf("Minimum number of coins needed to make %d is %d%n", 11, coinChange_solution_1(new int[]{1, 2, 5}, 11));
        System.out.printf("Minimum number of coins needed to make %d is %d%n", 3, coinChange_solution_1(new int[]{2}, 3));
        System.out.printf("Minimum number of coins needed to make %d is %d%n", 11, coinChange_solution_1(new int[]{1}, 0));

        System.out.println("Solution 2");
        System.out.printf("Minimum number of coins needed to make %d is %d%n", 11, coinChange_solution_2(new int[]{1, 2, 5}, 11));
        System.out.printf("Minimum number of coins needed to make %d is %d%n", 3, coinChange_solution_2(new int[]{2}, 3));
        System.out.printf("Minimum number of coins needed to make %d is %d%n", 11, coinChange_solution_2(new int[]{1}, 0));
    }

    public static int coinChange_solution_1(int[] coins, int amount) {

        // O(n*m) time, no. of distinct recursive calls * no. of work per recursive call.
        // O(m) space, where m is the amount.

        int[] dpArr = new int[amount+1];
        return coinChange(coins, amount, dpArr);
    }

    private static int coinChange(int[] coins, int amount, int[] dpArr) {
        if (amount <= 0) return 0;

        int ans = -1;

        if (dpArr[amount] != 0) return dpArr[amount];

        for (int coin : coins) {
            if (coin <= amount) {
                int val = coinChange(coins, amount - coin, dpArr);

                if (val != -1 && (ans == -1 || val + 1 < ans)) {
                    ans = val + 1;
                }
            }
        }

        dpArr[amount] = ans;
        return ans;
    }

    public static int coinChange_solution_2(int[] coins, int amount) {
        // Using iterative approach and dynamic programming.
        // O(n*d) time, where d is the number of denominations.
        // O(n) space

        int[] numOfCoins = new int[amount+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int toCompare;

        for (int denomination : coins) {
            for (int amt = 0; amt <= amount; amt++) {
                if (denomination <= amt) {
                    if (numOfCoins[amt - denomination] == Integer.MAX_VALUE) {
                        toCompare = numOfCoins[amt - denomination];
                    } else {
                        toCompare = numOfCoins[amt - denomination] + 1;
                    }
                    numOfCoins[amt] = Math.min(numOfCoins[amt], toCompare);
                }
            }
        }

        return numOfCoins[amount] != Integer.MAX_VALUE ? numOfCoins[amount] : -1;
    }
}
