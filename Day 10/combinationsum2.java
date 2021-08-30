class Solution 
{
   
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet();
        backtracking(result, candidates, target, 0, new ArrayList());
        return new ArrayList(result);
    }
    
    public void backtracking(Set<List<Integer>> result, int[] candidates, int target, int startIdx, List<Integer> temp)
    {
        if(target < 0) return;
        else if(target == 0) result.add(new ArrayList(temp));
        else
        {
            int prev = -1;
            for(int i = startIdx; i < candidates.length ; i++ )
            {
                if(prev != candidates[i])
                {
                    temp.add(candidates[i]);
                    backtracking(result, candidates, target - candidates[i], i+1, temp);
                    temp.remove(temp.size() - 1);
                }
                
                prev = candidates[i];
            }
        }
                
    }
}
