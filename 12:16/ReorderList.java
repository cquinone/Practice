package interviewprep;
import java.util.LinkedList; 
public class ReorderList {
	
	public static void main(String args[]) { 
		/* 
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		System.out.println(reorderList(l));
		System.out.println();
		*/
	}
	
	public static LinkedList reorderList(LinkedList l) {
		/* 
		 * http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
		 */
		LinkedList l1 = new LinkedList(); 
		LinkedList l2 = new LinkedList(); 
		LinkedList result = new LinkedList();
		
		for (int i = 0; i < l.size()/2; i++) { 
			l1.add(l.get(i));
		}
		
		for (int i = l.size()-1; i >= l.size()/2; i--) { 
			l2.add(l.get(i));
		}
		
		for (int i = 0; i < l.size(); i++) { 
			if (i%2 == 0)
				result.add(l1.get(i/2));
			else 
				result.add(l2.get(i/2));
		}
		return result;
		
	}

}
