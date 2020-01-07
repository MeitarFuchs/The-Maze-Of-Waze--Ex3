package Ex6;

import Ex4.MyConsole;

public class t6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= {1,2,3,4,8};
		boolean b=true;
		int start=MyConsole.readInt("enter the start");
		int end=MyConsole.readInt("enter the end");
		b=isSortedUp(a, start, end);
		System.out.println(" בטווח וממויין בסדר עולה?");
		if (b)
			System.out.println(" yes");
		else
			System.out.println(" no");

	}

	public static boolean isSortedUp(int a[], int start, int end)
	{
		boolean b=true;
		boolean bb=true;
		for (int i=0; i<a.length && b; i++)
		{
			if (a[i]>=start && a[i]<=end)
				{
					b=isSorted(a,i);
				}
			else
			{	
				bb=false;  // אפשר פשוט להחזיר שקר ישר
				System.out.println("לא בטווח "+bb);
				return bb;
			}

		}

		return b;
	}
	public static boolean isSorted(int []a,int i)
	{
		boolean b=true;
			if(i!=a.length-1 && b)
			{
				if (a[i]>=a[i+1])
				{
					b=false;
				}
			}
		return b;
	}
}
