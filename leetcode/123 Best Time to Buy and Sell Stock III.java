public class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length < 1) return 0;
        
        //--
        List<Integer> list = new ArrayList<Integer>();
		list.add(prices[0]);
		for(int j = 1 ; j < prices.length -1 ; j++){
			if(prices[j] >= prices[j-1] && prices[j] >= prices[j + 1] 
			|| prices[j] <= prices[j-1] && prices[j] <= prices[j + 1]){
				list.add(prices[j]);
			}
		}
		list.add(prices[prices.length - 1]);
		int[] c = new int[list.size()];
		for(int i = 0 ; i < c.length ; i++){
			c[i] = list.get(i);
		}
        //--
        
        int len = c.length;
        int[] a = new int[len];
        int[] b = new int[len];
        
        int low = c[0];
        int profit = 0;
        for(int i = 1 ; i < c.length ; i++){
            if(c[i] < low) 
                low = c[i];
            else
                profit = Math.max(profit, c[i] - low);
                a[i] = profit;
        }
        
        int high = c[len - 1];
        profit = 0;
        for(int i = len - 1 ; i >= 0 ; i--){
            if(c[i] > high)
                high = c[i];
            else
                profit = Math.max(profit, high - c[i]);
                b[i] = profit;
        }
        
        int result = 0;
        for(int i = 0 ; i < len ; i++){
            result = Math.max(result,a[i] + b[i]);
        }
        
        return result;
    }
}