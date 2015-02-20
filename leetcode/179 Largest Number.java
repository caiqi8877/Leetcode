public class Solution {
    public String largestNumber(int[] num) {
        if(num == null || num.length == 0) return null;
        
        List<String> numstrings = new ArrayList<String>(num.length);
        for (int x : num) numstrings.add(String.valueOf(x));
        
        Collections.sort(numstrings,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b + a).compareTo(a + b); 
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String x : numstrings){
            sb.append(x);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}