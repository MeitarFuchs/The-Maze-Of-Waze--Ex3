package Ex;

public class Ex1 {

	public static void main(String[] args) {
		// T  ODO Auto-generated method stub

		int num1= MyConsole.readInt("enter you'r first number");
		int sum1=0;
		int num2= MyConsole.readInt("enter you'r secound number");
		int sum2=0;

		while( num1!=0 || num2!=0 )
		{
			sum1+=num1%10;
			num1=num1/10;
			sum2+=num2%10;
			num2=num2/10;
		}
		if (sum1==sum2)
			System.out.println("Cool numbers");
		else
			System.out.println("No cool numbers");


		int n1= MyConsole.readInt("enter your first number");
		int n2= MyConsole.readInt("enter your secound number"); 

		while(n1!=0 && n2!=n1) 
		{	
			n1=n1/10;
		}
		if(n1==n2)
			System.out.println("Yes");
		else
			System.out.println("No");



		int h= MyConsole.readInt("How many woek hours this month?");
		int p=MyConsole.readInt("Choose your position \n (1) 100 \n (2) 80 \n (3) 65 \n (4) other ");	
		int wage=0;
		switch (p) {

		case 1: wage=100*h;
		System.out.println("your wage is="+ wage);
		break;
		case 2: wage=80*h;
		System.out.println("your wage is="+ wage);
		break;
		case 3: wage=65*h;
		System.out.println("your wage is="+ wage);
		break;
		default: wage=29*h;
		System.out.println("your wage is="+ wage);
		break;
		}


		int nw= MyConsole.readInt("How many workers do you have?");
		int sum=0; 
		for(int i=1; i<=nw; i++)
		{
			int hw= MyConsole.readInt("How many hours did this worker work?");
			int mw= MyConsole.readInt("How much for each hour?");
			sum= sum+hw*mw;
			if (hw>150)
				sum=sum+250;
		}

		System.out.println("Your expenses for this month are -"+ sum);

	}
}