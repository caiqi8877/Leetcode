public class Solution {
    public List<String> anagrams(String[] strs) {
        
        Map<String, String> map = new HashMap<String, String>();
        Set<String> rest = new HashSet<String>();
        
        List<String> result = new ArrayList<String>();
        if(strs.length == 0 || strs.length == 1) return result;
            
        for(String s : strs){
            String key = getSorted(s);
            String cur = map.put(key,s);
            if(cur != null){
                rest.add(key);
                result.add(cur);
            }
        }
        for(String key : rest){
            result.add(map.get(key));
        }
            
        return result;     
    }
    
    private String getSorted(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}