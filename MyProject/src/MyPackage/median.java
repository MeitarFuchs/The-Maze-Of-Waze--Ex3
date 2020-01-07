package MyPackage;

public class median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int med=0;
		int num=MyConsole.readInt("enter the length");
		int [] a= new int [num];
		for (int i=0; i<a.length;i=i+1) {
			a[i]=(int)(Math.random()*100);  
		}
		if (num%2==1) //גודל המערך אי זוגי
		{	
			med=a[num/2+1];
			System.out.println(med);
		}
		if (num%2==0) //גודל המערך זוגי
		{
			med=a[num/2];
			System.out.println(med);
			med=a[num/2+1];
			System.out.println("and "+med);
		}
jjj
	}

}
