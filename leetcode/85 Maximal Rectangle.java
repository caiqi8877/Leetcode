public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] a = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(i == 0) {
                    a[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    continue;
                }else{
                    a[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    if(a[i][j] == 1) a[i][j] += a[i-1][j];
                }
            }
        }
        int result = 0;
        for(int i = 0 ; i < row ; i++){
            result = Math.max(result, largestRectangleArea(a[i]));
        }
        return result;
    }
    
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length < 1) return 0;
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i <= height.length ; i++){
            int tall = i == height.length ? 0 : height[i];
            while(!stack.isEmpty() && tall <= height[stack.peek()]){
                int h = height[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int w = i - 1 - left;
                result = Math.max(h * w , result);
            }
            stack.push(i);
        }
        return result;
    }
}