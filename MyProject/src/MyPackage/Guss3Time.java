package MyPackage;

public class Guss3Time {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num= MyConsole.readInt("enter a number from 0-5");
		int numC=(int)(Math.random()*6);	
		int counter=1;

		while(counter<3 && num!=numC)
		{
			System.out.println("try again");
			num= MyConsole.readInt("enter a number from 0-5");
			counter=counter+1;
		}
		if (numC==num)
		{
			System.out.println("CORRECT");
		}
		else
			System.out.println("WRONG");

	}

}
