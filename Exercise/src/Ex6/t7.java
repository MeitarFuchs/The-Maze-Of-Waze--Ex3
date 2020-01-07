package Ex6;

public class t7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= {1,-2,-3,4,8};
		boolean b;
	
		b=mostPositive(a);
		System.out.println(" האם רוב האיברים חיוביים?");
		if (b)
			System.out.println(" yes");
		else
			System.out.println(" no");
		
	}
	public static boolean mostPositive(int a[]) 
	{
		int countG=0;
		int countB=0;
		for (int i=0; i<a.length; i++)
		{
			if (a[i]>0)
				{
					countG++;
				}
			else
			{	
				if(a[i]<=0)
					countB++;
			}
		}
		
		if (countG>=(a.length/2+1))
			return true;
		else
			return false;
		
	}
}
