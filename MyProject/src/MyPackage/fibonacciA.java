package MyPackage;

public class fibonacciA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n= MyConsole.readInt("enter n");
		int []a =new int[n];
		a[0]=1;
		a[1]=1;
		
		System.out.print(a[0]+"  "+a[1]+"  ");
		
		for(int i=2; i<a.length; i++)
		{
			a[i]= a[i-1]+a[i-2];
			System.out.print(a[i]+"  ");
		}

	}

}
