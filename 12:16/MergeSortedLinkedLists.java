package interviewprep;

import java.util.LinkedList; 
public class MergeSortedLinkedLists {

	public static void main(String args[]) { 
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		l1.add(1);
		l1.add(2); 
		l1.add(3); 
		l2.add(2); 
		l2.add(4); 
		l2.add(5);
		System.out.println(mergeSortedLinkedLists(l1,l2));
	}
	
	public static LinkedList mergeSortedLinkedLists(LinkedList l1, LinkedList l2) { 
		LinkedList result = new LinkedList();
		int findex = 0;
		int sindex = 0; 
		
		while (findex < l1.size() || sindex < l2.size()) { 
			if (findex < l1.size() && sindex < l2.size()) {
				if ((int)l1.get(findex) < (int)l2.get(sindex)) { 
					result.add(l1.get(findex));
					findex++;
				} else if ((int) l1.get(findex) > (int) l2.get(sindex)) { 
					result.add(l2.get(sindex));
					sindex++; 	
				} else { 
					result.add(l1.get(findex));
					result.add(l2.get(sindex));
					findex++;
					sindex++;
				}
			} else { 
				if (findex < l1.size()) { 
					result.add(l1.get(findex));
					findex++;
				} else { 
					result.add(l2.get(sindex)); 
					sindex++;
				}
			}
		}
		return result;
	}
}
