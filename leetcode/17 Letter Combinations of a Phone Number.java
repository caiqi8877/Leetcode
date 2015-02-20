public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        
        if(digits == null){
            return result;
        }
        
        String[] keyboard = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        int start = 0;
        
        buildResult(digits,start,"",keyboard,result);
        
        return result;
    }
    
    private void buildResult(String digits, int start, String s,String[] keyboard, List<String> result){
        if( start == digits.length()){
            result.add(s);
            return;
        }
        
        int num = digits.charAt(start) - '0';
        
        for(int i = 0 ; i < keyboard[num].length() ; i++){
            char temp = keyboard[num].charAt(i);
            buildResult(digits,start + 1,s + temp,keyboard,result);
        }
    }
}