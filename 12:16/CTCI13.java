package interviewprep;

import java.util.Set;
import java.util.HashMap;


public class CTCI13 {
	
	public static void main(String args[]) {
		System.out.println(CTCI13("1234","1234"));
		
	}
	
	public static boolean CTCI13(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		HashMap dict1 = new HashMap();
		HashMap dict2 = new HashMap();
		
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			if (dict1.containsKey(c1))
				dict1.put(c1,(int)dict1.get(c1)+1);
			else
				dict1.put(c1, 1);
			
			if (dict2.containsKey(c2))
				dict2.put(c2, (int)dict2.get(c2)+1);
			else 
				dict2.put(c2, 1);
		}
	
		Set k1s = dict1.keySet();
		for (Object key: k1s) {
			if (!dict2.containsKey(key))
				return false;
			if (dict1.get(key) != dict2.get(key))
				return false;
		}
		
		return true;
	}
}
