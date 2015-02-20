public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length ==0) return;
        dfs(board);
    }
    
    private boolean dfs(char[][] board){
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == '.'){
                    for(char num = '1' ; num <= '9' ; num++){
                        if(valid(num,i,j,board)){
                            board[i][j] = num;
                            if(dfs(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private boolean valid(char num, int i, int j, char[][] board){
        for(int row = 0 ;  row < 9; row++){
            if(board[row][j] == num) return false;
        }
        for(int col = 0 ;  col < 9; col++){
            if(board[i][col] == num) return false;
        }
        for(int row = (i / 3) * 3 ; row < (i / 3) * 3 + 3 ; row ++){
            for(int col = (j / 3) * 3 ; col < (j / 3) * 3 + 3 ; col++){
                if(board[row][col] == num) return false;
            }
        }
        return true;
    }
}
