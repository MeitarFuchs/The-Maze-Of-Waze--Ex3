package MyPackage;

public class calculeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a= MyConsole.readInt("Enter a number ");
		int b= MyConsole.readInt("Enter a number ");
		int c=MyConsole.readInt("Choose function \n (1) + \n (2) - \n (3) * \n (4) / \n (5) % ");	
		int f=0;
		switch (c) {

		case 1: f=a+b;
		System.out.println("a"+"+"+"b"+"="+ f);
		break;
		case 2: f=a-b;
		System.out.println("a"+"-"+"b"+"="+ f);
		break;
		case 3: f=a*b;
		System.out.println("a"+"*"+"b"+"="+ f);
		break;
		case 4: f=a/b;
		System.out.println("a"+"/"+"b"+"="+ f);
		break;
		case 5: f=a%b;
		System.out.println("a"+"%"+"b"+"="+ f);
		break;

		}



	}

}
