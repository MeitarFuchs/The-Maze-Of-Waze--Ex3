package Ex2; // מחשב את מספר הספרות של המספר שהכניס המשתמש

public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num= MyConsole.readInt("enter a number");
		int counter=0;

		while( num%10!=0)
		{

			counter++;
		}

		System.out.println("מספר הספרות הוא:" + " " +counter);	
	}

}
