class Solution {
    public int lengthOfLIS(int[] arr) {
        int ans = 1;
        int[] dp = new int[arr.length];  // create a DP array and initialise every element with 1
        Arrays.fill(dp,1);
		
		// traversing i in dp [ 1, ,1, 2 ,1, 1, 1, 1] , let i = 2
		//traversing j let j = 1  => dp[i] is now the greater value amongst dp[i] and dp[j+1] ,, i.e. checking if there is already an incresing sequesnce maintINED 
        for(int i=1;i<dp.length;i++) 
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    ans = Math.max(ans,dp[i]);
                }
            }
        }
      
        return ans;
    }
  
}
