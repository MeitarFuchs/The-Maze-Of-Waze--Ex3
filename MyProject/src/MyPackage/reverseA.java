package MyPackage;

public class reverseA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c= MyConsole.readInt("enter length");
		int []a =new int[c];
		for (int i=0; i<a.length;i=i+1) 
			a[i]=(int)(Math.random()*10); 

		int x=0;
		for(int i=0; i<a.length;i++)
			System.out.print(a[i]+" ");
		for(int i=0, j=a.length-1; i<a.length/2; i++, j--)
		{
			x=a[i];
			a[i]=a[j];
			a[j]=x;
		}
		System.out.println();
		for(int i=0; i<a.length;i++)
			System.out.print(a[i]+" ");

	}

}
