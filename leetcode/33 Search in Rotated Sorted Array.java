public class Solution {
    
    public int search(int[] A, int target) {
        
        int start = 0;
		int end = A.length - 1;
		return searchHelper(target,A,start,end);
	}
	
	public int searchHelper(int target,int[] a, int start, int end ){
		if(start == end && a[start] == target){
			return start;
		}else if(start == end && a[start] != target){
			return -1;
		}
		int mid = (start + end) >>1 ;
		if(a[start] <= a[mid]){
			if(target >= a[start] && target <= a[mid]){
				return searchHelper(target,a,start,mid);
			}else{
				return searchHelper(target,a,mid + 1,end);
			}
		}
		if(a[start] > a[mid]){	
			if(target >= a[mid] && target <= a[end]){
				return searchHelper(target,a,mid,end);
			}else{
				return searchHelper(target,a,start,mid - 1);
			}
		}
		return -1;
	}
    
}