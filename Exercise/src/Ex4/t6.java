package Ex4;

public class t6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=MyConsole.readInt("enter the length");
		int [] a= new int [n];
		int count=0;

		for (int i=0; i<a.length;i++) 
			a[i]=(int)(Math.random()*n);
		
		for (int i=0; i<a.length;i++) 
		{
			if (a[i]%3==0)
					count++;
		}
		for (int i=0; i<a.length;i++) 
			System.out.print(a[i]+" ");
		
		System.out.println();
		System.out.println("there are  "+count+"  numbers that are divisable by 3");
	}

}
