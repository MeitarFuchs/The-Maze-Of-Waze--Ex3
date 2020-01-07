package Ex4;

public class t1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=MyConsole.readInt("enter the length");
		int [] a= new int [n];
		int count0=0;
		
		for (int i=0; i<a.length;i++) 
			a[i]=(int)(Math.random()*n);
		
		for (int i=0; i<a.length;i++) 
			System.out.print(a[i]+" ");
		
		for (int i=0; i<a.length;i++)
		{
			if (a[i]==0)
					count0++;
		}
		System.out.println();
		System.out.println("there are  "+count0+"  zero in the arr");
		
	}

}
