package interviewprep;

import java.util.Arrays; 
import java.util.ArrayList;

public class CreateSet {
	public static void main(String args[]) { 
		/*
		int[] t0 = {1,1,1,1,2,8,5,4,6};
		int[] t0res = createSet(t0);
		for (int i = 0; i < t0res.length; i++)  
			System.out.println(t0res[i]);	
		System.out.println();
		
		int[] t1 = {9,8,7,6,6,5,4,3};
		int[] t1res = createSet(t1); 
		for (int i = 0; i < t1res.length; i++) 
			System.out.println(t1res[i]);
		System.out.println();
		
		int[] t2 = {1,1}; 
		int[] t2res = createSet(t2); 
		for (int i = 0; i < t2res.length; i++) 
			System.out.println(t2res[i]);
		System.out.println();
		*/
		
	}
	
	public static int[] createSet(int[] arr) { 
		ArrayList res = new ArrayList();
		Arrays.sort(arr); 
		for (int i = 0; i < arr.length-1; i++) { 
			if (arr[i] != arr[i+1])
				res.add(arr[i]);
		}
		res.add(arr[arr.length-1]);
		return alToArr(res);
	}
	
	public static int[] alToArr(ArrayList al) { 
		int[] res = new int[al.size()];
		for (int i = 0; i < al.size(); i++) { 
			res[i] = (int)al.get(i);
		}
		return res;
	}
}
