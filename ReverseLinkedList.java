package interviewprep;
import java.util.LinkedList;
public class ReverseLinkedList {
	public static void main(String args[]) { 
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2); 
		l.add(3);
		System.out.println(reverseLinkedList(l));
	}
	
	public static LinkedList reverseLinkedList(LinkedList l) { 
		for (int i = 0; i < l.size()/2; i++) { 
			Object temp = l.get(i);
			l.set(i, l.get(l.size()-1-i));
			l.set(l.size()-1-i,temp);
		}
		return l;
	}
}
