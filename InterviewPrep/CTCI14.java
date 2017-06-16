package interviewprep;

public class CTCI14 {
	public static void main(String args[]){
		System.out.println(CTCI14("Mr John Smith"));
	}
	
	public static String CTCI14(String str){
		/*
		 * Write a method to replace all spaces in a string with '%20:
		 * you may assume that the string has sufficient space at the 
		 * end of the string to hold the additional characters, and 
		 * that you are given the "true" length of the string.
		 */
		StringBuilder result = new StringBuilder();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == ' ')
				result.append("%20");
			else
				result.append(str.charAt(i));
		}
		return result.toString();
	}
	
}
