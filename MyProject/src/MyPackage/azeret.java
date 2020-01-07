package MyPackage;

public class azeret {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= MyConsole.readInt("enter a number");
		int prodact=1;
		int counter=1;
		while(counter<=a)
		{
			prodact= prodact*counter;
			counter=counter+1;
		}
		System.out.println(prodact);




	}

}
