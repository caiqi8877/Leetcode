public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        String sign = ( (numerator ^ denominator) >> 31 == 0) ? "" : "-";
        long a = Math.abs((long)numerator);
        long b = Math.abs((long)denominator);
        long left = a / b;
        long right = a - left * b;
        if(right == 0) return sign + String.valueOf(left);
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        List<Long> result = new ArrayList<Long>();
        boolean repeatedFlag = true;
        int index = 0;
        while(!map.containsKey(right)){
            map.put(right,index);
            index++;
            right *= 10;
            result.add(right/b);
            right = right - (right/denominator) * denominator;
            if(right == 0){   
            	repeatedFlag = false;
            	break;
            }
        }
        if(map.get(right) != null)  index = map.get(right);
        StringBuilder r = new StringBuilder();
        for(Long x : result){
            r.append(x);
        }
        if(repeatedFlag) {
            r.append(")");
            r.insert(index, "(");
        }
        r.insert(0,".");
        r.insert(0,left);
        r.insert(0,sign);
        return r.toString();
    }
}