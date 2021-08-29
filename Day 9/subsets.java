class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    void solve(int [] nums,int n,int idx,List<Integer>temp)
    {
        if(idx==n)
        {
            res.add(new ArrayList(temp));
            return ;
        }
        solve(nums,n,idx+1,temp);
        temp.add(nums[idx]);
        solve(nums,n,idx+1,temp);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        solve(nums,n,0,new ArrayList());
        return res;
        
    }
}
