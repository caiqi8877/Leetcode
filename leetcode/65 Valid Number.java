public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        int head = 0;
        int tail = s.length() - 1;
        while(head <= tail && s.charAt(head) == ' ') head++;
        if(head > tail) return false;
        while(head <= tail && s.charAt(tail) == ' ') tail--;
        
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        
        if(s.charAt(head) == '+' || s.charAt(head) == '-') head++;
        
        for(int i = head ; i <= tail ; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num = true;
            }else if(s.charAt(i) == '.'){
                if(dot || exp) return false;
                dot = true;
            }else if(s.charAt(i) == 'e'){
                if(exp || !num) {
                    return false;
                }
                exp = true;
                num = false;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(s.charAt(i-1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return num;
    }
}