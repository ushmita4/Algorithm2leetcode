class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        else if(n==2)return Math.max(nums[0],nums[1]);
       // return Math.max(solve(Arrays.copyOfRange(nums,0,n-1),nums.length-1),
        //                solve(Arrays.copyOfRange(nums,1,n),nums.length-1));
        int[] arr1 = Arrays.copyOfRange(nums,0,n-1);
        int[] arr2 = Arrays.copyOfRange(nums,1,n);
        int a = optimize(arr1);
        int b = optimize(arr2);
        return Math.max(a,b);
        
    }
    int optimize(int[] arr){
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=arr[0];
        dp[2]=Math.max(arr[0],arr[1]);
        for(int i=3;i<=n;i++){
            dp[i]=Math.max(arr[i-1]+dp[i-2],dp[i-1]);
        }
        return dp[n];
    }
    public int solve(int[] nums,int n){
        if(n<=0)return 0;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        return Math.max(nums[n-1]+solve(nums,n-2),solve(nums,n-1));
    }
}
