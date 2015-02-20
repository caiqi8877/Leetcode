public class Solution {
    public int numDecodings(String code) {
        if(code == null || code.length() == 0) return 0;
		if(code.charAt(0) == '0') return 0;
		int[] ways = new int[code.length() + 1];
		ways[0] = 1;
		ways[1] = 1;
		
		for(int i = 1 ; i < code.length() ; i++){
			if(code.charAt(i) != '0')
			{			
				ways[i + 1] = ways[i];
			}
			String substr = code.substring(i - 1, i + 1);
			int temp = Integer.parseInt(substr);
			if( temp >= 10 && temp <=26){
				ways[i + 1] += ways[i - 1];
			}
		}
		return ways[code.length()];
    }
}