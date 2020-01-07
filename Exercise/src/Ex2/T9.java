package Ex2;//וצא את המספר המקסימאלי מבין שלושה מספרים שנקלטים ע"י המשתמש

public class T9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= MyConsole.readInt("enter n");
		int m= MyConsole.readInt("enter m");
		int k= MyConsole.readInt("enter k");
		int max=0;

		if (m<=n && m<=k)
		{
			max=m;
			System.out.println("m is max"+ " " + max);
		}
		else if (n<=m && n<=k)
		{
			max=n;
			System.out.println("n is max"+ " " + max);
		}
		else if (k<=n && k<=m)
		{
			max=k;
			System.out.println("k is max"+ " " + max);
		}
		else if (n==k||n==m||m==k)
		{
			max=k;
			System.out.println("the max is"+ " " + max);
		}

		//System.out.println("max"+ max);

	
	}

}
