public class Solution {
    public int singleNumber(int[] A) {
        
        int ec1 = 0, ec2 = 0, ec3 = 0;
        for(int x : A){
            ec3 = ec2 & x;
            ec2 = (ec2 | (ec1 & x)) & (~ec3);
            ec1 = (ec1 | x) & (~ec3);   
        }
            return ec1;
    }
}