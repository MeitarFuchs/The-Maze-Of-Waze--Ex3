package Ex4;

public class t7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int [] a= new int [3];

		for (int i=0; i<a.length; i++) 
		{
			int n=MyConsole.readInt("enter a number");
			a[i]=n;
		}

		System.out.println("befor:");

		for (int i=0; i<a.length;i++) 
			System.out.print(a[i]+" ");
		
		int c=a[0];???
		
		for (int i=1; i<a.length; i++) 
		{
			while( a[i]< a[i-1]  )
			{
				if (a[i]<a[i-1])
				{	
					c=a[i];
					a[i]=a[i-1];
					a[i-1]=c;
				}
			}
		}

		System.out.println();
		System.out.println("after:");
		for (int i=0; i<a.length;i++) 
			System.out.print(a[i]+" ");

		System.out.println();
	}

}
