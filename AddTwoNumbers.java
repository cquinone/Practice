package interviewprep;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

public class AddTwoNumbers {
	
	public static void main(String args[]) { 
		LinkedList l1 = new LinkedList();
		l1.add(4);
		l1.add(9);
		l1.add(0);
		
		LinkedList l2 = new LinkedList();
		l2.add(8);
		l2.add(2);
		l2.add(9);
		
		System.out.println(addTwoNumbers(l1,l2));
	}
	
	public static LinkedList addTwoNumbers(LinkedList l1, LinkedList l2) { 
		/* 
		 * http://www.programcreek.com/2012/12/add-two-numbers/
		 */
		StringBuilder num1 = new StringBuilder();
		StringBuilder num2 = new StringBuilder();
		LinkedList result = new LinkedList();
		
		for (int i = 0; i < l1.size(); i++) { 
			num1.append(Integer.toString((int)l1.get(i)));
		}
		
		for (int i = 0; i < l2.size(); i++) { 
			num2.append(Integer.toString((int)l2.get(i)));
		}
		
		int sum = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
		String stringsum = Integer.toString(sum);
		
		for (int i = stringsum.length()-1; i >= 0; i--) { 
			result.add(Integer.parseInt(String.valueOf(stringsum.charAt(i))));
		}
		
		return result;
	}

}
