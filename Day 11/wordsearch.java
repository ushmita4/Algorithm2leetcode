class Solution {
    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(str[0] == board[i][j]) {
                    if(findWord(board, i, j, str, 0)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean findWord(char[][] board, int row, int col, char[] word, int index) {
        if(index >= word.length) return true;
        if(row < 0 || row >= board.length) return false;
        if(col < 0 || col >= board[row].length) return false;
        
        if(board[row][col] != word[index]) return false;
        char temp = board[row][col];
        board[row][col] = '0';
        
        boolean flag = false;
        
        flag = flag || findWord(board, row-1, col, word, index+1);
        flag = flag || findWord(board, row, col-1, word, index+1);
        flag = flag || findWord(board, row, col+1, word, index+1);
        flag = flag || findWord(board, row+1, col, word, index+1);
        
        board[row][col] = temp;
        return flag;        
    }
    
}
