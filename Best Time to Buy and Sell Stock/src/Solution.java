class Solution {

    // Problem statement: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    public static void main(String[] args) {
        System.out.println("Max Profit: " + maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Max Profit: " + maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {

        // O(n) time | O(1) space

        if (prices.length <= 1) return 0;

        int currentMin = prices[0];
        int maxProfitSoFar = 0;

        for (int currentPrice : prices) {
            if (currentPrice > currentMin) {
                int currentProfit = currentPrice - currentMin;
                maxProfitSoFar = Math.max(maxProfitSoFar, currentProfit);
            }

            currentMin = Math.min(currentMin, currentPrice);
        }

        return maxProfitSoFar;
    }
}