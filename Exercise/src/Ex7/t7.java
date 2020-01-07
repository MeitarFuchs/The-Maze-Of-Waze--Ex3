package Ex7;

import Ex4.MyConsole;

public class t7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=MyConsole.readString("enter a word");
		
		char c0=s.charAt(0);
		char c0new;
	
		int g='a'-'A';
		int v=c0;
		int vnew;
		vnew=v-g;
		c0new=(char)vnew;
		String newStr = ""+c0new+s.substring(1, s.length());
		
				System.out.println(newStr);
				
	}
}
