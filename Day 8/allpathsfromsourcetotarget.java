class Solution {
   public void solve(int[][] graph,int start,List<Integer> arr,List<List<Integer>> list){
        if(start==graph.length-1){
            list.add(new ArrayList<Integer>(arr));
            return;
        }
        for(int i=0;i<graph[start].length;i++){
            int ele=graph[start][i];
                arr.add(ele);
                solve(graph,ele,arr,list);
                arr.remove(arr.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        arr.add(0);
        solve(graph,0,arr,list);
        return list;
    }
}
