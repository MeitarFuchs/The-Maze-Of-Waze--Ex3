package Ex3;
//(כתוב תוכנה המקבלת מספר טבעי ומדפיסה הפוך משולש שווי-שוקיים וישר-זווית של כוכביות. (הקלט הוא מספר הכוכביות בכל אחד מניצבי המשולש

public class T7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n= MyConsole.readInt("enter a number");

		for(int i=n; i>=1; i--) 
		{

			for(int j=i; j<n; j++)     // for (int j = i; j <n; j++) {
			{
				System.out.print(" ");

			}
			for(int h=0; h<i; h++)		//	for (int j = 0; j < i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
