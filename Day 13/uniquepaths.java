class Solution {
    public int uniquePaths(int m, int n) {
        table = new int[m][n];
        table[m-1][n-1] = 1;
        return count(m, n, 0, 0);
    }
    
    public int count(int m, int n, int cm, int cn){
        if(0 != table[cm][cn]){
            return table[cm][cn];
        }
        int rCount = 0;
        int dCount = 0;
        if(cm < m-1){
            dCount = count(m, n, cm+1, cn);
        }
        if(cn < n-1){
            rCount = count(m, n, cm, cn+1);
        }
        table[cm][cn] = dCount + rCount;
        return dCount + rCount;
    }
    
    int [][] table;
}
