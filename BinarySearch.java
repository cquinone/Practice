package interviewprep;

public class BinarySearch {
	public static void main(String args[]) {
		int[] t0 = {0,1,2,3,4,5,6,7,8,9,10};
		int[] t1 = {10,98,99};
		System.out.println(ibinsearch(t0,0,10,10));
		System.out.println(ibinsearch(t1,0,2,10));
		
	}
	
	public static int ibinsearch(int[] arr,int low,int upp, int target) {
		while (low <= upp) {
			int mid = low + (upp-low)/2;
			if (arr[mid] == target)
				return mid;
			else if (target > arr[mid]) 
				low = mid+1;
			else 
				upp = mid-1;
		}
		return -1;
	}
	
	public static int rbinsearch(int[] A,int low,int upp,int target) {
		if (low <= upp){
			int mid = low +  (upp-low)/2;
			if (target == A[mid])
				return mid;
			else if (target > A[mid])
				return rbinsearch(A,mid+1,upp,target);
			else
				return rbinsearch(A,low,mid-1,target);
		} else 
			return -1;

	}

}
