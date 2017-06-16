package interviewprep;

public class DecimalToBinary {
	public static void main(String args[]){
		System.out.println("0b11".substring(2));
		System.out.println(binaryToDecimal("0b11"));
		System.out.println(decimalToBinary(4));
		
	}
	
	public static String decimalToBinary(int num){
		StringBuilder res = new StringBuilder();
		res.append("0b");
		int maxIndex = 0;
		
		while (num - Math.pow(2,maxIndex) > 0)
			maxIndex++;
		
		for (int i = maxIndex; i > -1; i--) {
			int difference = num - (int)Math.pow(2,i);
			if (difference >= 0) {
				res.append("1");
				num = difference;
			} else {
				res.append("0");	
			}
		}
		return res.toString();
	}
	
	public static int binaryToDecimal(String bin) { 
		String rev = reverse(bin.substring(2));
		int dec = 0;
		for (int i = 0; i < bin.substring(2).length(); i++) { 
			int bit = Integer.parseInt(String.valueOf(rev.charAt(i)));
			dec += bit*Math.pow(2,bit);
		}
		return dec;
	}
	
	public static String reverse(String str) { 
		char[] arr = str.toCharArray();
		for (int i = 0; i < str.length()/2; i++) { 
			char temp = arr[i];
			arr[i] = arr[str.length()-1-i];
			arr[str.length()-1-i] = temp;
		}
		return String.valueOf(arr);
	}
}
