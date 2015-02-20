public class Solution {
    public int numDistinct(String S, String T) {
        int[][] c = new int[S.length() + 1][T.length() + 1];
        for(int i = 0 ; i <= S.length() ; i++)
            for(int j = 0 ; j <= i && j <= T.length() ; j++)
                c[i][j] = j == 0 ? 1 :  c[i-1][j] + ( S.charAt(i-1) == T.charAt(j-1) ? c[i-1][j-1] : 0 )  ;
        return c[S.length()][T.length()];
    }
}