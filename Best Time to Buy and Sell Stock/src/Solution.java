class Solution {

    // Problem statement: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    public static void main(String[] args) {
        System.out.println("Max Profit: " + maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Max Profit: " + maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {

        // O(n) time | O(1) space

        int maxProfit = 0;
        int minimumPriceSoFar = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minimumPriceSoFar;
            if (currentProfit > maxProfit) maxProfit = currentProfit;

            minimumPriceSoFar = Math.min(minimumPriceSoFar, prices[i]);
        }

        return maxProfit;
    }
}