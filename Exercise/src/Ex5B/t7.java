package Ex5B;

import java.util.Arrays;

public class t7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {1,2,3,4,5};
		print(a);
		print(evenOddSort(a));


	}
	public static int [] evenOddSort(int [] a)
	{
		int tamp;	
		for (int i=0; i<a.length; i++)
		{
			if(a[i]%2!=0) ???????
			{
				if (a[i+1]%2==0)
				{
					tamp=a[i];
					a[i]=a[i+1];
					a[i+1]=tamp;
				}
			}
		}
		return a;
	}
	
	public static void print(int [] a)
	{
		System.out.println(Arrays.toString(a));
	}
}

