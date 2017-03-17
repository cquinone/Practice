package interviewprep;

public class DigitSum {
	public static void main(String args[]){
		System.out.println(lessThan10(38));
		
	}

	public static int lessThan10(int num){
		while (num > 10)
			num = digitSum(num);
		return num;
	}
	
	public static int digitSum(int num){
		int sum=0;
		while (num>0){
			sum += num%10;
			num/=10;
		}
		return sum;
	}
}
