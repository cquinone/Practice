package interviewprep;

public class KthPrime {
	public static void main(String args[]) {
		System.out.println(kthPrime(2));
		
	}
	public static int kthPrime(int k) {
		int found = 0;
		int guess = 0;
		
		while(found <= k) {
			guess++;
			if (isPrime(guess))
				found++;
		}
		
		return guess;
	}
	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		int max = (int)Math.pow(num, .5);
		
		for (int i = 3; i < max+1; i+=2) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
