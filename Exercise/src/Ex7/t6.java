package Ex7;

import Ex4.MyConsole;

public class t6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=MyConsole.readString("enter a word");
		char c0=s.charAt(0);
		char c1=s.charAt(1);
		char c2=s.charAt(2);
		String newStr = "";
		
				if (c0<c1 && c0<c2)
				{
					if (c1<c2)
						newStr= newStr +c0+c1+c2;
					else 
						newStr= newStr +c0+c2+c1;
				}
				else
					if (c1<c0 && c1<c2)
					{
						if (c0<c2)
							newStr= newStr +c1+c0+c2;
						else 
							newStr= newStr +c1+c2+c0;
					}
					else
							if (c2<c0 && c2<c1)
							{
								if (c0<c1)
									newStr= newStr +c2+c0+c1;
								else 
									newStr= newStr + c2+c1+c0;
							}
				System.out.println(newStr);
				
	}
}
