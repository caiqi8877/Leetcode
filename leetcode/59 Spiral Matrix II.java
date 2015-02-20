public class Solution {
    public int[][] generateMatrix(int n) {
        int re = n - 1;
        int ce = n - 1;
        int rb = 0;
        int cb = 0;
        int num = 1;
        int[][] matrix = new int[n][n];
        while(rb <= re && cb <= ce){
            for(int i = cb ; i <= ce ; i++){
                matrix[rb][i] = num++;
            }
            rb++;
            for(int i = rb ; i <= re ; i++){
                matrix[i][ce] = num++;
            }
            ce--;
            for(int i = ce; i >= cb && rb <= re; i--){
                matrix[re][i] = num++;
            }
            re--;
            for(int i = re; i >= rb && cb <= ce; i--){
                matrix[i][cb]  = num++;
            }
            cb++;
        }
		return matrix;
		
    }
}