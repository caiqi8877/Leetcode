public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set= new HashSet<List<Integer>> ();
        
        if(num.length < 4) return result;
        Arrays.sort(num);
        for(int i = 0 ; i < num.length - 3 ; i++){
            for(int j = i + 1 ; j < num.length - 2; j++){
                int left = j + 1;
                int right = num.length - 1;
                
                while(left < right){
                    int sum = num[i] + num[j] + num[left] + num[right];
                    
                    if(sum > target){
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[left]);
                        temp.add(num[right]);
                        
                        if(!set.contains(temp)){
                            set.add(temp);
                            result.add(temp);
                        }
                        
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}