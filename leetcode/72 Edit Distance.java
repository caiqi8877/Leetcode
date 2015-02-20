public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dis = new int[l1 + 1][l2 + 1];
        for(int i = 0 ; i <= l1 ; i++){
            for(int j = 0 ; j <= l2 ; j++){
                if(i == 0) {
                    dis[0][j] = j;
                }else if(j == 0){
                    dis[i][0] = i;
                }else{
                    int result = Math.min(dis[i-1][j-1],Math.min(dis[i-1][j],dis[i][j-1])) + 1;
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        result = Math.min(result,dis[i-1][j-1]);
                    }
                    dis[i][j] = result;
                }
                
            }
        }
        return dis[l1][l2];
    }
}