class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        final int N = nums.length;
        int[] dp = new int[N];
        int res = 0;
        for (int i = 2; i < N; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}
