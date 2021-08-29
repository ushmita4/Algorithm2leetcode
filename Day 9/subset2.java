class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //result is stored in this set to avoid duplicates
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0) return new ArrayList<>(res);
        
        //sort to check for duplicates within set 
        Arrays.sort(nums);
        backtrack(res, new ArrayList(), nums, 0);
        return new ArrayList<>(res);
    }
    
    private void backtrack(Set<List<Integer>> res, List<Integer> arr, int[] nums, int start) {
        //add all intermediate results to final array without any base condition
        res.add(new ArrayList<>(arr));
        
        for (int i=start; i<nums.length; i++) {
            if (i>start && nums[i] == nums[start]) continue;
            arr.add(nums[i]);
            //DFS approach to handle all the subsets starting with nums[i]
            backtrack(res, arr, nums, i+1);
            //trim last element from the intermediate results aka. backtrack
            arr.remove(arr.size()-1);
        }
    }
}
