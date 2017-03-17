package interviewprep;

public class CTCI91 {
	public static void main(String args[]) {
		System.out.println(CTCI91(10));
	}
	
	public static int CTCI91(int n) {
		/*
		 * A child is running up a staircase with n steps, and can hop 
		 * either 1 steps, 2 steps, or 3 steps at a time. Implement a 
		 * method to count how many possible ways the child can move 
		 * up the stairs
		 */
		return stephelper(n,0,0);
	}
	
	public static int stephelper(int n,int step,int inc) {
		int newstep = step + inc;

		if (newstep == n)
			return 1;
		else if (newstep > n)
			return 0;
		else
			return stephelper(n,newstep,1) + 
					stephelper(n,newstep,2) +
					stephelper(n,newstep,3);
		
	}
}
