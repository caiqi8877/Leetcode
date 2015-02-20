public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int l1 = n1.length();
        int l2 = n2.length();
        int[] a = new int[l1 + l2 - 1];
        for(int i = 0 ; i < l1 ; i++){
            for(int j = 0 ; j < l2 ; j++){
                a[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry  = 0;
        for(int i = 0 ; i < a.length ; i++){
            int digit = (a[i] + carry) % 10;
            carry = (a[i] + carry) / 10;
            
            sb.insert(0,digit);
        }
        if(carry != 0) sb.insert(0,carry);
        while(sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        return sb.toString();
    }
}