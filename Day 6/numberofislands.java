class Solution {
  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          helper(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private static void helper(char[][] A, int row, int col) {
    if (row < 0 || row >= A.length || col < 0 || col >= A[row].length || A[row][col] == '0') return;
    A[row][col] = '0'; // Island goes bye bye
    int[][] SHIFT = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int[] dir : SHIFT) {
      helper(A, row + dir[0], col + dir[1]);
    }
  }
}
