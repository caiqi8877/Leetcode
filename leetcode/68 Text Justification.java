public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if(words == null || words.length == 0) return result;
        int begin = 0;
        int l = 0;
        
        for(int i = 0 ; i < words.length ; i++){
            if(l + i - begin + words[i].length() > L){
                result.add( build(words,begin,i-1,L-l,L,false) );
                begin = i;
                l = 0;
            } 
            l += words[i].length();
        }
        result.add(build(words,begin,words.length - 1,L-l,L,true));
        return result;
    }
    
    public String build(String[] words, int begin, int end, int room, int L, boolean lastLine){
        StringBuilder sb = new StringBuilder();
        
        int n = end - begin;
        int space =  n == 0 ? 0 : room / n;
        
        for(int i = begin ; i < end ; i++){
            sb.append(words[i]);
            if(n == 0 || lastLine){
                if(sb.length() < L) sb.append(" ");
            }else{
                for(int j = 0 ; j < space ; j++){
                    sb.append(" "); 
                }
                if(i - begin < room % n){
                    sb.append(" ");
                }
            }
        }
        
        sb.append(words[end]);
        while(sb.length() < L) sb.append(" ");
        return sb.toString();
    }
}