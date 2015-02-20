public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
		int sum = 1;
		for(int i = 1 ; i <= n ; i++){
			list.add(i);
			if( i != n) sum *= i;
		}
		StringBuilder result = new StringBuilder();
		for(int i = n - 1 ; i >= 1 ; i--){
			int num = k == 0 ? 0 : (k - 1) / sum ;
			int temp = list.get(num);
			list.remove(num);
			k = k - num * sum;
			sum /= i;
			result.append(temp);
		}
		result.append(list.get(0));
		return result.toString();
    }
}