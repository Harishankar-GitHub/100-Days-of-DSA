import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/counting-bits/
    // Bitwise operators: https://www.programiz.com/java-programming/bitwise-operators

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] resultArr = new int[n+1];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = getNumberOfBits(i);
        }

        return resultArr;
    }

    private static int getNumberOfBits(int n) {
        int count = 0;

        for (int i = 0; i <= 31; i++) {
            if ((n & (1 << i)) > 0) count++;
        }

        return count;

        // 1 << i will give a number where ith bit is 1 and every other bit is 0.
        // So, if (n AND (1 leftShift i) > 0) then increment count.
    }
}
