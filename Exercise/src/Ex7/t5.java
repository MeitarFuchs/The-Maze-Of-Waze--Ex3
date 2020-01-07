package Ex7;

import Ex4.MyConsole;

public class t5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=MyConsole.readString("enter a String with a few words");

		char c;
		c=' ';
		int countC=0;

		for (int i=0; i<s.length(); i++)
		{
			if (s.charAt(i)==c)
				countC++;
		}
		
		if (s.charAt(s.length()-1)==c)// במקרה ויש רווח בסוף המשפט
			countC--;
		
		System.out.println("there is "+(countC+1)+" words in your senten");

	}
}
