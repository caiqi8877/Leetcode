public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 1;
        int row = dungeon.length - 1;
        int col = dungeon[0].length - 1;
        int[][] a = new int[row + 1][col + 1];
        a[row][col] = dungeon[row][col];
        for(int i = col - 1 ; i >= 0 ; i--){
            a[row][i] = Math.min(dungeon[row][i], a[row][i+1] + dungeon[row][i]);
        } 
        for(int j = row - 1 ; j >= 0 ; j--){
            a[j][col] = Math.min(dungeon[j][col], a[j + 1][col] + dungeon[j][col]);
        }
        for(int i = row - 1 ; i >= 0 ; i--){
            for(int j = col - 1 ; j >= 0 ; j--){
                a[i][j] = Math.min(dungeon[i][j], Math.max(a[i + 1][j], a[i][j + 1]) + dungeon[i][j]);
            }
        }
        return Math.max(1,1 - a[0][0]);
    }
}