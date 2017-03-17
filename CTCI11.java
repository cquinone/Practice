package interviewprep;

import java.util.HashMap;

public class CTCI11 {
	public static void main(String args[]){
		System.out.println(CTCI11("a"));
		System.out.println(CTCI11("abc"));
		System.out.println(CTCI11("aa"));
		System.out.println(CTCI11("abcdefghijklmna"));
	}
	
	public static boolean CTCI11(String str) {
		/*
		 * Implement an algorithm to determine if a string has all 
		 * unique characters.  What if you cannot use additional data 
		 * structures?
		 */
		HashMap dict = new HashMap();
		for (int i=0; i<str.length(); i++) {
			char key = str.charAt(i);
			if (dict.containsKey(key) == false)
				dict.put(key,1);
			else {
				return false;
			}
		}
		return true;
	}
}
