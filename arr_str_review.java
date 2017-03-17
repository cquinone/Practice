package interviewprep;
import java.util.Arrays;
public class arr_str_review {
	
	public static void main(String args[]) {
		//testSizeOfLastWord();
		/* 
		int[] arr1 = {5,4,8,-1,7,-9};
		int[] arr2 = {5,4,8,-1,7,-9};
		System.out.println(Arrays.equals(arr1,arr2));
		Arrays.sort(arr1);
		for (int i = 0; i < arr1.length; i++) { 
			System.out.println(arr1[i]);
		}
		*/
		
		System.out.println((int)'Z' - 64);
	}
	
	//SORT: return a sorted array of integers 
	public static int[] Arrays(int[] arr1, int[] arr2) { 
		Arrays.sort(arr1); //sorts the array.  returns nothing
		Arrays.equals(arr1,arr2);
		return arr1;
	}
	
	//REMOVESPACES: return the reverse of the given string using a 
	//StringBuilder
	public static String removeSpaces(String str) {
		//return str.replace(" ","");
		StringBuilder newString = new StringBuilder();
		for (int i=0; i<str.length(); i++){
			if (str.charAt(i) != ' ')
				newString.append(str.charAt(i));
		}
		return newString.toString();
	}
	
	//Integer.parseInt(String str) review
	public static int readString(String figure) {
		return Integer.parseInt(figure);
	}
	
	//str.split(char c) review
	public static int month(String date) {
		String[] darr = date.split("/");
		return Integer.parseInt(darr[0]);
	}
	
	
	//REVERSESTRING: return the reverse of the given string using 
	//a StringBuilder
	public static String reverseString(String str ) {
		char[] arr = str.toCharArray();
		int len = str.length();
		StringBuilder sb = new StringBuilder();
		char temp;
		for (int i=0; i<len/2; i++) {
			temp = arr[i];
			arr[i] = arr[len-1-i];
			arr[len-1-i] = temp;
		}
		//return String.valueOf(arr);
		
		for (int i=0; i<len; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}	
	
	//STRIPNONALPHA: returns any nonalpha characters from the string
	public static String stripNonAlpha(String str) {
		StringBuilder res = new StringBuilder();
		for (int i=0; i<str.length(); i++) {
			int ascii = (int)str.charAt(i);
			if (((int)'a'<= ascii && ascii<=(int)'z') ||
					((int)'A'<=ascii && (ascii<(int)'Z')))
					res.append(str.charAt(i));
		}
		return res.toString();
	}
	
	//SIZEOFLASTWORD: returns the size of the last word in a string 
	public static int sizeOfLastWord(String str) {
		String reverse = reverseString(str);
		boolean nonWhiteSpaceFound = false;
		int size = 0;
		
		for (int i=0; i<str.length(); i++) {
			if (reverse.charAt(i) != ' ') {
				if (nonWhiteSpaceFound == false) {
					nonWhiteSpaceFound = true;
					size+=1;
				} else {
					size+=1;
				}
			} else {
				if (nonWhiteSpaceFound == true)
					return size;
			}
		}
		return size;
	}
	
	public static void testSizeOfLastWord(){
		System.out.println(sizeOfLastWord("Hello mate")==4);
		System.out.println(sizeOfLastWord("Tricky ayee?  ")==5);
	}
}
