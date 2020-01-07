package MyPackage;

public class MishvaLiniarit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a= MyConsole.readDouble("enter a");
		double b=MyConsole.readDouble("enter b");

		if (a!=0)
			System.out.println(1.0*b/a);
		else if(b==0)
			System.out.println("אינסוף פתרונות");
		else
			System.out.println("אין פתרונות");

	}

}
