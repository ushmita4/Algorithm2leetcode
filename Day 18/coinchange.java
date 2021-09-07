class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1; // or throw exception
        if (amount == 0) return 0;
        final int N = coins.length, MAX = amount+1;
        int[][] dp = new int[N+1][MAX]; // amount <= 10^4
        Arrays.fill(dp[0], MAX);
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            int coin = coins[i-1];
            for (int j = 0; j <= amount; j++) {
                if (j >= coin) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coin] + 1);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][amount] >= MAX ? -1 : dp[N][amount];
    }
}
