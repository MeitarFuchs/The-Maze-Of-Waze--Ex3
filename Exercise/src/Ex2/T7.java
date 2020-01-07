package Ex2; //בודק מהו המחלק הגדול ביותר של שני המספרים הנקלטים ע"י המשתמש
//אפשר להתחיל את הקאונט מלמעלה ואז ברגע שאמצא אעשה פחות חיפוש
public class T7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n= MyConsole.readInt("enter n");
		int m= MyConsole.readInt("enter m");
		int x=0;
		int ml=0;	// המחלק

		while(x<=n || x<=m)
		{
			if(n%x==0 && m%x==0)
			{
				ml=x;
			}
			x++;
		}
		
		System.out.println(ml);
		
		// FOR דרך נוספת ע"י שימוש בלולאת 
		//int n= MyConsole.readInt("enter n");
		//int m= MyConsole.readInt("enter m");
		//int x=1;
		// for(int i=1; i<=n; i++){
		//if(n%i==0 && m%i==0)
		//ml=i;
		//}
		//System.out.println(ml);
		
	}

}
