package Ex6;

import Ex4.MyConsole;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int p=MyConsole.readInt("enter a number");
		int q=MyConsole.readInt("enter a number");
		int gcd=0;
		gcd=gcd(p,q);
		System.out.println("the gcd is  "+gcd);
	}
	public static int gcd(int p, int q)
	{
		int gcd=0;
		int min=0;
		if (p<q)
			min =p;
		else
			min=q;
		
		for (int i=1; i<=min; i++)
		{
			if (p%i==0 && q%i==0)
				gcd=i;
			
		}

		return gcd;
	}
}
