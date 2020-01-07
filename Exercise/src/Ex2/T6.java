package Ex2;// n בחזקת m


public class T6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= MyConsole.readInt("enter a hezka");
		int m= MyConsole.readInt("enter a number");
		int p=1;
		
		int counter=1;
		while(counter<=n)
		{
			p= p*m;
			counter=counter+1;
		}
		System.out.println(p);

	}

}
