package Ex2; //וצא את המספר המינמלי מבין שלושה מספרים שנקלטים ע"י המשתמש

public class T8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n= MyConsole.readInt("enter n");
		int m= MyConsole.readInt("enter m");
		int k= MyConsole.readInt("enter k");
		int min=0;

		if (m<n && m<k)
		{
			min=m;
			System.out.println("m is min"+ " " + min);
		}
		else if (n<m && n<k)
		{
			min=n;
			System.out.println("n is min"+ " " + min);
		}
		else if (k<n && k<m)
		{
			min=k;
			System.out.println("k is min"+ " " + min);
		}

		//System.out.println("min"+ min);

	}

}
