package Ex4;

public class t8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=MyConsole.readInt("enter a number");
		int sum=0;
		
		while(n>0)
		{
			sum+=(n%10);
			n=n/10;
		}
		
		System.out.println(sum);
	}

}
