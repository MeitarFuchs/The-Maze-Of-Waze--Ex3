package Ex6;

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= {1,2,3,0,5};
		boolean b=true;
		b=isSorted(a);
		if (b)
			System.out.println("yes");
		else
			System.out.println("no");

	}
	public static boolean isSorted(int []a)
	{
		boolean b=true;
		for (int i=0; i<a.length && b; i++)
		{
			if(i!=a.length-1)
			{
				if (a[i]>=a[i+1])
				{
					b=false;
				}
			}
		}		
		return b;
	}
}
