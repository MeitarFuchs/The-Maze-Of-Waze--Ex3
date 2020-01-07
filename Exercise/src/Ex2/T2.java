package Ex2; //סכום כל המספרים עד המספר שנקלט ע"י המשתמש

import Ex2.MyConsole;

public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a= MyConsole.readInt("enter a number");
		int sum=0;
		int counter=1;
		while(counter<=a)
		{
			sum= sum*counter;
			counter=counter+1;
		}
		System.out.println(sum);

	}

}
