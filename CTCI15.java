package interviewprep;

public class CTCI15 {
	public static void main(String args[]) {
		System.out.println(CTCI15("aaaaaaaaaaaaaaaaaaabccc"));
	}
	
	public static String CTCI15(String str) {
	/* 
	 * Implement a method to perform basic string compression using 
	 * the counts of repeated characters if the compressed string 
	 * would not become smaller than the original string, your method
	 * should return the original string.
	 */
		StringBuilder res = new StringBuilder();
		int index = 0;
		
		while (index < str.length()) { 
			char curr = str.charAt(index);
			int consec = consecutiveLetters(str,index);
			res.append(curr);
			res.append(consec);
			index+=consec;
		}
		
		if (res.toString().length() >= str.length())
			return str;
		else
			return res.toString();
	}
	
	public static int consecutiveLetters(String str, int index) {
		char curr = str.charAt(index);
		int count = 0;
		
		while (index < str.length() && str.charAt(index) == curr) {
			count++;
			index++;
		}
		
		return count;
	}
	

}
