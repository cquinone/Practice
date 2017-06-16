package interviewprep;

public class CTCI77 {
	public static void main(String args[]){
		System.out.println(kthSpecialNumber(2));
	}
	
	public static boolean onlyPrimeFactors(int num) {
		/*
		 * Design an algorithm to find the kth number such that the only
		 * prime factors are 3, 5, and 7
		 */
		if (num==1)
			return false;
		
		while (num%3==0)
			num/=3;
		
		while (num%5==0)
			num/=5;
		
		while (num%7==0)
			num/=7;
		
		return num==1;
	}
	
	public static int kthSpecialNumber(int k){
		int found=0;
		int guess=0;
		while (found<=k) {
			guess++;
			if (onlyPrimeFactors(guess))
				found++;
		}
		return guess;
	}
}
