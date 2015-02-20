public class Solution {
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