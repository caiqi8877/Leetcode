public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<String>();
        if(s == null || s.length() < 10) return new ArrayList<String>(result);
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < s.length() - 9 ; i++){
            int code = 0;
            for(int j = i ; j < 10 + i ; j++){
                char c = s.charAt(j);
                code = code << 3 | (c & 7) ;
            }
            if(set.contains(code)){
                result.add(s.substring(i,i+10));
            }else{
                set.add(code);
            }
        }
        return new ArrayList<String>(result);
    }
}